package com.spring.dto.email;

public class Email {
    private String subject;
    private String from;

    public Email(String subject, String from) {
        this.subject = subject;
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
