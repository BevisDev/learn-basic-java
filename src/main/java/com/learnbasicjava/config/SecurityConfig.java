package com.learnbasicjava.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user1").password(getPasswordEncoder().encode("123")).roles("ADMIN")
//                .and()
//                .withUser("user2").password(getPasswordEncoder().encode("456")).roles("USER")
//                .and()
//                .withUser("user3").password(getPasswordEncoder().encode("789")).roles("ADMIN", "USER");
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Cross-site resource forgery
        http.csrf().disable().cors().disable();
        http.authorizeRequests()
                .antMatchers("/security/home/about", "/security/order/about").hasRole("ADMIN")
                .antMatchers("/security/order/**").hasAnyRole("STAFF", "ADMIN")
                .antMatchers("/security/home/contact").authenticated()
                .anyRequest().permitAll();

        // http.httpBasic();

        http.formLogin()
                .loginPage("/security/login/form")
                .loginProcessingUrl("/spring/login")
                .defaultSuccessUrl("/security/login/success")
                .failureUrl("/security/login/failure");
        http.rememberMe()
                .tokenValiditySeconds(5 * 24 * 60 * 60);
        http.logout()
                .logoutUrl("/spring/logout")
                .logoutSuccessUrl("/security/logout/success");

        http.exceptionHandling().accessDeniedPage("/security/access/denied");

//        http.oauth2Login()
//                .loginPage("/security/login/form")
//                .defaultSuccessUrl("/oauth2/login/success", true)
//                .failureUrl("/security/login/failure")
//                .authorizationEndpoint()
//                .baseUri("/oauth2");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**", "/css/**", "/images/**");
    }

}