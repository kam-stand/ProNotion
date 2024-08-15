package com.spring;

import com.spring.utils.Email;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.mail.MessagingException;

@SpringBootApplication
public class App {
    public static void main(String[] args) throws MessagingException {
        SpringApplication.run(App.class, args);
        System.out.println("Hello World!");
    }
}