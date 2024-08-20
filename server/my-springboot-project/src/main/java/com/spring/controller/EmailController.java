package com.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.mail.Message;
import javax.mail.MessagingException;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.EmailResponseDto;
import com.spring.utils.Email.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    // @GetMapping("/fetch")
    // public CompletableFuture<List<EmailResponseDto>> fetchEmails() {
    // return emailService.fetchEmails();

    // }

    @GetMapping("/fetch")
    public ResponseEntity<List<String>> fetchEmails() {
        List<Message> emails = emailService.fetchMessages();
        List<String> emailSubjects = new ArrayList<>();
        for (Message email : emails) {
            try {
                emailSubjects.add(email.getSubject().toString());
            } catch (MessagingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return new ResponseEntity<>(emailSubjects, HttpStatus.OK);
    }

}