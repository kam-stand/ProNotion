package com.spring;

import com.spring.utils.Email;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.mail.MessagingException;

@SpringBootApplication
public class App {
    public static void main(String[] args) throws MessagingException {
        SpringApplication.run(App.class, args);
        Email email = new Email();
        email.listenEmail("kamrul.hassan@stonybrook.edu","Fahim84590@123111402!");
        System.out.println("Hello World!");
    }
}