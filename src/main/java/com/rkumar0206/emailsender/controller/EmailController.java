package com.rkumar0206.emailsender.controller;

import com.rkumar0206.emailsender.constants.Constants;
import com.rkumar0206.emailsender.model.MailInfo;
import com.rkumar0206.emailsender.service.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity<String> sendEmail(@RequestParam("sendTo") String sendTo) {

        if (sendTo != null && !sendTo.trim().isEmpty()) {

            try {

                MailInfo mailInfo = new MailInfo(
                        sendTo,
                        "THIS IS A TEST MESSAGE",
                        Constants.MAIL_DEMO_TEXT_HTML
                );

                emailService.sendEmail(mailInfo);
                return ResponseEntity.ok("Mail Sent successfully. Please check your mail.");
            } catch (MessagingException e) {
                return ResponseEntity.internalServerError().body(e.getMessage());
            }
        } else {

            return ResponseEntity.badRequest().body("Please send username");
        }

    }
}
