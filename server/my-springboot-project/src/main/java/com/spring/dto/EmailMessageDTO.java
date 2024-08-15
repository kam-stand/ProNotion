package com.spring.dto;

import javax.mail.Address;
import java.util.Date;

public class EmailMessageDTO {

    private Address[] from;

    private Address[] to;

    private String subject;

    private String cc;

    private String bcc;

    private Date sentDate;

    private String body;

    public EmailMessageDTO (){}


    public EmailMessageDTO(Address[] from, Address[] to, String subject, String cc, String bcc, Date sentDate,  String body) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.cc = cc;
        this.bcc = bcc;
        this.body = body;
        this.sentDate = sentDate;
    }

    public Address[] getFrom() {
        return from;
    }

    public void setBody(String body) {
        this.body = body;
    }
    public String getBody() {
        return body;
    }

    public void setFrom(Address[] from) {
        this.from = from;
    }

    public Address[] getTo() {
        return to;
    }

    public void setTo(Address[] to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }
}
