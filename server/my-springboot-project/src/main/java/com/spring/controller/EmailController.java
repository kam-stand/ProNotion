package com.spring.controller;

import com.spring.service.Email.EmailFetcherService;
import com.spring.service.Email.EmailService;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    EmailService emailService;

@Autowired
EmailFetcherService emailFetcherService;

    // @GetMapping
    // public CompletableFuture<List<Email>> fetchAllEmails( @RequestParam int start, @RequestParam int end ) {
    //     return emailService.fetchEmail(start, end);
    // }

    // @GetMapping
    // public CompletableFuture<List<String>> fetchAllEmails( ) {
    //     return emailService.getAsyncFrom("kamrul.hassan@stonybrook.edu", "Fahim84590@123111402!");
    // }

     @GetMapping("/fetch")
    public CompletableFuture<ResponseEntity<List<String>>> getEmailsFrom() {
        // Call the asynchronous method
        return emailService.getAsyncFrom("kamrul.hassan@stonybrook.edu", "Fahim84590@123111402!")
                           .thenApply(fromList -> ResponseEntity.ok(fromList))
                           .exceptionally(e -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                                             .body(null));
    }
    

}
