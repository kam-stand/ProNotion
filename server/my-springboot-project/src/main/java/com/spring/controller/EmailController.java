package com.spring.controller;

import com.spring.dto.Email;
import com.spring.service.Email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    EmailService emailService;

    @GetMapping
    public List<Email> fetchAllEmails() {
        return emailService.fetchEmail("kamrul.hassan@stonybrook.edu", "Fahim84590@123111402!");
    }
}
