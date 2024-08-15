package com.spring.controller;

import com.spring.dto.EmailMessageDTO;
import com.spring.utils.Email;
import com.spring.utils.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.ArrayList;
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
        Message [] messages = emailService.fetchEmails();
        List<EmailMessageDTO> emailMessageDTO = new ArrayList<>();

        System.out.println(messages.length);

        try{
            for (Message message : messages) {
                EmailMessageDTO dto = new EmailMessageDTO();
                dto.setFrom(message.getFrom());
                dto.setSubject(message.getSubject());
                dto.setBody(message.getContent().toString());
                emailMessageDTO.add(dto);
            }
            return new ResponseEntity<>(emailMessageDTO, HttpStatus.OK);
        }
        catch (MessagingException | IOException e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

    }




}
