package com.spring.utils.Email;

import java.util.Properties;

import javax.mail.Session;

public class Email {

    private Protocol protocol;

    private Session session;

    public Email() {
    }

    public Email(Protocol protocol, Session session) {
        this.protocol = protocol;
        this.session = session;

    }

    public Protocol getProtocol() {
        return this.protocol;
    }

    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }

    public Session getSession() {
        return this.session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

}
