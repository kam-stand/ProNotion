package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.mail.MessagingException;

@SpringBootApplication
@EnableAsync
public class App {
    public static void main(String[] args) throws MessagingException {
        SpringApplication.run(App.class, args);
        System.out.println("Hello World!");
    }
}