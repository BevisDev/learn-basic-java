package com.learnbasicjava.config;

import com.learnbasicjava.interceptor.LayoutInterceptor;
import com.learnbasicjava.interceptor.LoggerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    // preHandle
    @Autowired
    LoggerInterceptor loggerInterceptor;

    // postHandle
    @Autowired
    LayoutInterceptor layoutInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggerInterceptor)
                .addPathPatterns("/i18n/**")
                .excludePathPatterns("/i18n/about");
// Cach 1	.addPathPatterns("/home/index", "/home/contact");

        registry.addInterceptor(layoutInterceptor)
                .addPathPatterns("/**");
    }

}