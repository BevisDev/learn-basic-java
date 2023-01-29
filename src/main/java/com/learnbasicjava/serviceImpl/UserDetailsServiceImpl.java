package com.learnbasicjava.serviceImpl;

import com.learnbasicjava.dao.AccountDAO;
import com.learnbasicjava.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    AccountDAO dao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Account account = dao.findById(username).get();
            // constructor User in UserDetails
            // password is auto BCrypt and compare in security
            return new User(account.getUsername(), account.getPassword(), this.getAuthorities(account));
        } catch (Exception e) {
            throw new UsernameNotFoundException(username + " not found !");
        }
    }

    private Collection<SimpleGrantedAuthority> getAuthorities(Account account) {
        return account.getAuthorities()
                .stream()
                .map(a -> new SimpleGrantedAuthority("ROLE_" + a.getRoles().getId()))
                .collect(Collectors.toList());
    }

}
