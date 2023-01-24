package com.learnbasicjava.controller;

import com.learnbasicjava.mailer.Mail;
import com.learnbasicjava.mailer.MailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMailController {

    @Autowired
    MailerService mailerService;

    @RequestMapping("/mailer/send")
    public String index() {
        Mail mail = new Mail();
        mail.setFrom("truongthanhbinh572000@gmail.com");
        mail.setTo("trthanhbinh5720@gmail.com");
        mail.setSubject("TEST MAIL");
        mail.setText("Spring Boot");
        mail.setCc("ttbinh5720@gmail.com");
        mailerService.queue(mail);
        return "mailer/send";
    }
}
