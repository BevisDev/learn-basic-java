package com.learnbasicjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class Scope2Controller {

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpSession session;
    @Autowired
    ServletContext app;

    @RequestMapping("/scope/demo2")
    public String demo2() {
        // request
        String r1 = (String) request.getAttribute("r1");
        if (r1 != null) {
            r1 = r1.toUpperCase();
            request.setAttribute("r2", r1);
        }

        //session
        String s1 = (String) session.getAttribute("s1");
        s1 = s1.toUpperCase();
        session.setAttribute("s2", s1);

        //application
        String ap1 = (String) app.getAttribute("ap1");
        ap1 = ap1.toUpperCase();
        app.setAttribute("ap2", ap1);
        return "scope/demo";
    }

}