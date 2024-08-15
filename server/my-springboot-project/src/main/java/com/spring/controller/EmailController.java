package com.spring.controller;

import com.spring.dto.EmailMessageDTO;
import com.spring.utils.Email;
import com.spring.utils.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.Message;
import java.util.List;

@RestController
@RequestMapping("/email")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public ResponseEntity<?> sendEmail(@RequestBody Email email) {
        return new ResponseEntity<>(emailService.sendEmail(email), HttpStatus.OK);

    }

    @GetMapping("/fetch")
    public ResponseEntity<?> fetchEmail() {
        return new ResponseEntity<>(emailService.fetchEmails(), HttpStatus.OK);
    }

}
