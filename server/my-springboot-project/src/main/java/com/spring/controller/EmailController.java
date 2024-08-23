package com.spring.controller;

import com.spring.dto.Email;
import com.spring.service.Email.EmailService;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    EmailService emailService;

    @GetMapping
    public CompletableFuture<List<Email>> fetchAllEmails( @RequestParam int start, @RequestParam int end ) {
        return emailService.fetchEmail(start, end);
    }
}
