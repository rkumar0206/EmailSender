package com.rkumar0206.emailsender.service;

import com.rkumar0206.emailsender.constants.Constants;
import com.rkumar0206.emailsender.model.MailInfo;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String username;

    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendEmail(MailInfo mailInfo) throws MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");

        mimeMessageHelper.setTo(mailInfo.getSendTo());
        mimeMessageHelper.setSubject(mailInfo.getSubject());
        mimeMessageHelper.setFrom(this.username);
        mimeMessageHelper.setText(Constants.MAIL_DEMO_TEXT_HTML, true);

        new Thread(() -> {

            System.out.println("Sending mail...");
            javaMailSender.send(mimeMessage);
            System.out.println("Mail sent successfully...");
        }).start();


    }
}
