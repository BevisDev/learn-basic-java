package com.learnbasicjava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/i18n")
public class I18NController {

    @RequestMapping("/index")
    public String index() {
        return "i18n/index";
    }

    @RequestMapping("/about")
    public String about() {
        return "i18n/about";
    }

    @RequestMapping("/contact")
    public String contact() {
        return "i18n/contact";
    }
}
