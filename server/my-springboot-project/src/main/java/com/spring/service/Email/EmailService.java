package com.spring.service.Email;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.spring.dto.Email;

@Service
public class EmailService {

    public List<Email> fetchEmail(String username, String password, int start, int end) {
        EmailProtocol emailProtocol = new EmailProtocol(username, password);
        Session imapSession = emailProtocol.ImapSession();

        List<Email> emails = new ArrayList<>();

        try {
            Store store = imapSession.getStore("imaps");
            store.connect(username, password);

            Folder inboxFolder = store.getFolder("INBOX");
            inboxFolder.open(Folder.READ_ONLY);

            Message[] messages = inboxFolder.getMessages(start, end);

            for (Message message : messages) {
                String subject = message.getSubject();
                String from = null;

                // Check if subject is null or empty, and handle it accordingly
                if (subject == null || subject.isEmpty()) {
                    subject = "(No Subject)";
                }

                // Get the sender's address
                Address[] fromAddresses = message.getFrom();
                if (fromAddresses != null && fromAddresses.length > 0) {
                    from = fromAddresses[0].toString();
                } else {
                    from = "(Unknown Sender)";
                }

                emails.add(new Email(subject, from));
            }

            // Close the folder and store
            inboxFolder.close(false);
            store.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return emails;
    }



    @Async
    public CompletableFuture<List<Email>> getEmails(String username, String password, int start, int end){

        EmailProtocol emailProtocol = new EmailProtocol(username, password);
        Session imapSession = emailProtocol.ImapSession();

        List<Email> emails = new ArrayList<>();

        try {
            Store store = imapSession.getStore("imaps");
            store.connect(username, password);

            Folder inboxFolder = store.getFolder("INBOX");
            inboxFolder.open(Folder.READ_ONLY);

            Message[] messages = inboxFolder.getMessages(start, end);

            for (Message message : messages) {
                String subject = message.getSubject();
                String from = null;

                // Check if subject is null or empty, and handle it accordingly
                if (subject == null || subject.isEmpty()) {
                    subject = "(No Subject)";
                }

                // Get the sender's address
                Address[] fromAddresses = message.getFrom();
                if (fromAddresses != null && fromAddresses.length > 0) {
                    from = fromAddresses[0].toString();
                } else {
                    from = "(Unknown Sender)";
                }

                emails.add(new Email(subject, from));
            }

            // Close the folder and store
            inboxFolder.close(false);
            store.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return CompletableFuture.completedFuture(emails);

    }
}
