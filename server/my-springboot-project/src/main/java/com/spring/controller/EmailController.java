package com.spring.controller;

// import com.spring.dto.Email;
// import com.spring.service.Email.EmailService;

// import java.util.List;
// import java.util.concurrent.CompletableFuture;
// import java.util.logging.Logger;

// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.Email;
import com.spring.dto.EmailSend;
import com.spring.service.Email.EmailService;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/email")
public class EmailController {

    private static final Logger logger = LoggerFactory.getLogger(EmailController.class);

    @Autowired
    EmailService emailService;

    @GetMapping
    public CompletableFuture<List<Email>> fetchEmail(@RequestParam int start, @RequestParam int end) {
        logger.debug("Fetching emails from start: {} to end: {}", start, end);

        CompletableFuture<List<Email>> result = emailService.getEmails("kamrul.@stonybrook.edu", "@123111402!", start, end);
        logger.debug("Async processing started");
        return result;
    }


    @PostMapping
    public CompletableFuture<Boolean> sendEmail( @RequestBody EmailSend emailSend){
        CompletableFuture<Boolean> result = emailService.sendEmail(".hassan@.edu", "@123111402!", emailSend);
        return result;
    }
}
