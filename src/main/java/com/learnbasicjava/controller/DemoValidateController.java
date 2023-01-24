package com.learnbasicjava.controller;

import com.learnbasicjava.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping("/account")
@Controller
public class DemoValidateController {

    //  ====================== Start Demo validate
    @GetMapping("/form")
    public String form(@ModelAttribute("student") Student s) {
        s.setFullname("");
        s.setCountry("US");
        s.setGender(true);
        return "demo-validate/form";
    }

    // show list country
    @ModelAttribute("countries")
    public Map<String, String> getCountries() {
        Map<String, String> map = Map.of("VN", "VietNam", "US", "America", "SG", "Singapore");
        return map;
    }

    @PostMapping("/save")
    public String save(Model model,
                       @Validated @ModelAttribute("student") Student s,
                       BindingResult errors) {
        if (errors.hasErrors()) {
            model.addAttribute("message", "vui Long fix Errors");
        } else {
            model.addAttribute("message", "hop li");
        }
        return "demo-validate/form";
    }
    
    //  ====================== End Demo validate
}
