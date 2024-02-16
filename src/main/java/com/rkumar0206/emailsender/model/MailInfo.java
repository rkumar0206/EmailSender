package com.rkumar0206.emailsender.model;

public class MailInfo {

    private String sendTo;
    private String subject;
    private String messageText;

    public MailInfo(String sendTo, String subject, String messageText) {
        this.sendTo = sendTo;
        this.subject = subject;
        this.messageText = messageText;
    }

    public String getSendTo() {
        return sendTo;
    }

    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
