package com.learnbasicjava.controller;

import com.learnbasicjava.dao.AccountDAO;
import com.learnbasicjava.dao.AuthoritiesDAO;
import com.learnbasicjava.dao.RolesDAO;
import com.learnbasicjava.entity.Account;
import com.learnbasicjava.entity.Authorities;
import com.learnbasicjava.entity.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/security")
public class Security2Controller {

    @Autowired
    private AccountDAO dao;

    @Autowired
    private PasswordEncoder pe;

    @Autowired
    private AuthoritiesDAO authoritiesDAO;

    @Autowired
    private RolesDAO rolesDAO;


    @ResponseBody
    @RequestMapping("/account/create")
    public String create() {
        Account account = new Account("user6",pe.encode("123"), "user6", "user@gmail.com","user.png",true, List.of());
        dao.save(account);
        return "OK";
    }

    @RequestMapping(value = {"/home/index", "/order/index"})
    public String index() {
        return "/security/home/index";
    }

    @RequestMapping(value = {"/home/about", "/order/about"})
    public String about() {
        return "/security/home/about";
    }

    @RequestMapping(value = {"/home/contact", "/order/contact"})
    public String contact() {
        return "/security/home/contact";
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = {"/home/feedback", "/order/feedback"})
    public String feedback() {
        return "/security/home/feedback";
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/home/authenticate")
    public String authenticate(Authentication auth) {
        System.out.println(auth.getName());
        System.out.println(auth.getAuthorities());
        System.out.println(auth.isAuthenticated());
        System.out.println(auth.getPrincipal());
        return "/security/home/authenticate";
    }

}
