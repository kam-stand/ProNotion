package com.spring.controller;



import com.spring.dto.email.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.service.EmailService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private  EmailService emailService;




//    @GetMapping
//    @Async("asyncTask")
//    public void fetchEmails()  {
//        CompletableFuture<List<Email>> completableFuture = emailService.getEmail();
//        List<String> emails = new ArrayList<>();
//        for (Email email : completableFuture.join()) {
//            emails.add(email.toString());
//        }
//        for (String email : emails) {
//            System.out.println(email);
//        }
//    }

    @GetMapping
    @Async("asyncTask")
    public CompletableFuture<List<Email>> fetchEmails() {
        CompletableFuture<List<Email>> completableFuture = emailService.getEmail();

        return completableFuture;
    }

    @GetMapping("/test")
    @Async
    public CompletableFuture<String> testAsync() {
        return CompletableFuture.completedFuture("Async response");
    }

}
