package com.learnbasicjava.mailer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MailerServiceImpl implements MailerService {

    private List<Mail> list = new ArrayList<>();

    @Autowired
    JavaMailSender sender;

    @Override
    public void queue(Mail mail) {
        list.add(mail);
    }

    @Scheduled(fixedRate = 2000)
    public void run() {
        while (!list.isEmpty()) {
            // get first mail
            Mail mail = list.remove(0);
            this.send(mail);
        }

    }

    void send(Mail mail) {
        try {
            MimeMessage msg = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(msg, true, "utf-8");
            helper.setFrom(mail.getFrom()); // người gửi
            helper.setTo(mail.getTo()); // người nhận
            helper.setCc(mail.getCc()); // những người đồng nhận
            helper.setSubject(mail.getSubject()); // tiêu đề email
            helper.setText(mail.getText(), true); // nội dung email
            //rely lại người gửi, còn ko mặc định về gmail trong properties
            helper.setReplyTo(mail.getFrom());

            File file = new File("D:\\ECLIPSE workspace\\Schedules\\src\\main\\resources\\application.properties");
            helper.addAttachment(file.getName(), file);
            sender.send(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
