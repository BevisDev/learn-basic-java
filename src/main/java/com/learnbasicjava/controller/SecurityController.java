package com.learnbasicjava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/security")
public class SecurityController {

    @RequestMapping("/access/denied")
    public String accessDenied(Model model) {
        model.addAttribute("message", "KO cos quyen truy cap");
        return "forward:/security/login/form";
    }

    @RequestMapping("/login/form")
    public String loginForm() {

        return "security/login";
    }

    @RequestMapping("/login/success")
    public String loginSuccess(Model model) {
        model.addAttribute("message", "Login success");
        return "forward:/security/login/form";
    }

    @RequestMapping("/login/failure")
    public String loginfailure(Model model) {
        model.addAttribute("message", "Sai info login");
        return "forward:/security/login/form";
    }

    @RequestMapping("/logout/success")
    public String logoutSuccess(Model model) {
        model.addAttribute("message", "Ban da dang xuat");
        return "forward:/security/login/form";
    }

//    @RequestMapping("/oauth2/login/success")
//    public String oauth2LoginSuccess(Model model, OAuth2AuthenticationToken oauth2) {
//        OAuth2User user = oauth2.getPrincipal();
//        System.out.println(user.getName());
//        System.out.println((String) user.getAttribute("email"));
//        System.out.println((String) user.getAttribute("name"));
//        model.addAttribute("message", "dang nhap thanh cong");
//        return "forward:/security/login/form";
//    }

}
