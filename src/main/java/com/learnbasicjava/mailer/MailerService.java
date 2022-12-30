package com.learnbasicjava.mailer;

public interface MailerService {
    void queue(Mail mail);
}
