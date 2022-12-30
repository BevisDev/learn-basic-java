package com.learnbasicjava.controller;

import com.learnbasicjava.bean.Student;
import com.learnbasicjava.dao.AccountDAO;
import com.learnbasicjava.dao.AccountUploadFileDAO;
import com.learnbasicjava.entity.AccountUploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.Map;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountUploadFileDAO dao;

    // scope global
    @Autowired
    ServletContext app;

    @GetMapping("register")
    public String register1() {
        return "account-loadfile/register";
    }

    /**
     * Upload file image ( Account - load file )
     *
     * @param model
     * @param account
     * @param file
     * @return
     */
    @PostMapping("register")
    public String register2(Model model, AccountUploadFile account, @RequestPart("photo_file") MultipartFile file) {
        try {
            // check file Emty ko ?
            if (file.isEmpty()) {
                account.setPhoto("user.png");
            } else {
                // lay ten goc cua file
                account.setPhoto(file.getOriginalFilename());
                String path = app.getRealPath("/photos/" + file.getOriginalFilename());
                File newFile = new File(path);
                // if folder photos no exist => create
                if (!newFile.getParentFile().exists()) {
                    newFile.getParentFile().mkdirs();
                }
                file.transferTo(newFile);
            }
            // save to db
            dao.save(account);
            // show message when success
            model.addAttribute("message", "Success");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "fail");
        }
        return "account-loadfile/register";
    }

    // ================ End upload file

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
