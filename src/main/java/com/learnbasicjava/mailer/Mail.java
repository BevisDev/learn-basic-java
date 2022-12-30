package com.learnbasicjava.mailer;


import lombok.Data;

@Data
public class Mail {
    String from, to, subject, text, file, cc, bcc;
}
