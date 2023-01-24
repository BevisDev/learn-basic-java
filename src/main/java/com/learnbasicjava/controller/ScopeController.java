package com.learnbasicjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class ScopeController {

    /**
     * request nhu Model, share data in 1 request
     */
    @Autowired
    HttpServletRequest request;

    /**
     * 1 session open khi ket noi browser
     * close connection khi close browser
     */
    @Autowired
    HttpSession session;

    /**
     * application la noi store all components,
     * co the create, get, read all activity
     */
    @Autowired
    ServletContext app;

    /**
     * to response has cookie for client
     */
    @Autowired
    HttpServletResponse response;

    @RequestMapping("/scope/demo1")
    public String demo1() {
        request.setAttribute("r1", "Request");
        session.setAttribute("s1", "Session");
        app.setAttribute("ap1", "Application");
        return "forward:/scope/demo2";
    }

    // =============== COOKIE store at client is a text < 4kb ============

    /**
     * check cookie at client
     *
     * @return
     */
    @RequestMapping("/cookie/create")
    public String create() {
        Cookie cookie = new Cookie("user", "ThanhBinh");
        cookie.setMaxAge(5 * 24 * 60 * 60); // 5 ngay
        cookie.setPath("/"); // toàn website
        // cookie.setHttpOnly(true); // ko cho sửa đổi phía client

        response.addCookie(cookie); // gui ve client
        return "/scope/cookie";
    }

    @RequestMapping("/cookie/read")
    public String read(@CookieValue("user") String username) {
        System.out.println(username);
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
//			if (cookie.getName().equals("user")) {
//				return cookie.getValue();
//			}
            request.setAttribute("cookie", cookie.getValue());
            System.out.println(cookie.getName() + "=>" + cookie.getValue());
        }
        return "/scope/cookie";
    }

    @RequestMapping("/cookie/delete")
    public String delete() {
        Cookie cookie = new Cookie("user", "");
        cookie.setMaxAge(0); // 5 ngay
        cookie.setPath("/"); // toàn website

        response.addCookie(cookie); // gui ve client
        return "/scope/cookie";
    }

}
