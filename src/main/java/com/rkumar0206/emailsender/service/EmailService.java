package com.rkumar0206.emailsender.service;

import com.rkumar0206.emailsender.model.MailInfo;
import jakarta.mail.MessagingException;

public interface EmailService {

    void sendEmail(MailInfo mailInfo) throws MessagingException;
}
