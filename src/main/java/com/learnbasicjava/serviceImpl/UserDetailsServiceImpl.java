package com.learnbasicjava.serviceImpl;

import com.learnbasicjava.dao.AccountDAO;
import com.learnbasicjava.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    AccountDAO dao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Account account = dao.findById(username).get();
            UserDetails userDetails = new UserDetailsImpl(account);
            return userDetails;
        } catch (Exception e) {
            throw new UsernameNotFoundException(username + " not found !");
        }
    }
}
