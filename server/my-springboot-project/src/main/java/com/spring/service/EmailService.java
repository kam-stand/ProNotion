package com.spring.service;

import com.spring.config.EmailProtocol;
import com.spring.dto.email.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Service
public class EmailService {

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Async
    public CompletableFuture<List<Email>> getEmail() {
        List<Email> emails = new ArrayList<>();
        EmailProtocol emailProtocol = new EmailProtocol("kamrul.hassan@stonybrook.edu", "Fahim84590@123111402!");
        Session session = emailProtocol.ImapSession();
        try {
            Store store = session.getStore("imaps");
            store.connect(emailProtocol.getUsername(), emailProtocol.getPassword());
            Folder folder = store.getFolder("INBOX");
            folder.open(Folder.READ_WRITE);
            Message[] messages = folder.getMessages(1, 20);
            for (Message message : messages) {
                String subject = message.getSubject();
                if (subject.isEmpty()) {
                    subject = "Empty";
                }
                String from = message.getFrom()[0].toString();
                Email email = new Email(subject, from);
                emails.add(email);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return CompletableFuture.completedFuture(new ArrayList<>()); // Return empty list on error
        }
        return CompletableFuture.completedFuture(emails);
    }



}
