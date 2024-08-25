package com.spring.service.Email;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.Flags.Flag;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.spring.dto.Email;
import com.spring.dto.EmailSend;

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


    public CompletableFuture<Boolean> sendEmail(String username, String password, EmailSend emailSend){
        try {
            EmailProtocol emailProtocol = new EmailProtocol(username, password);

        Session SMTP = emailProtocol.SmtpSession();
        Message msg = new MimeMessage(SMTP);

            msg.setFrom(new InternetAddress(username));
            msg.setSubject(emailSend.getSubject());
            msg.setRecipient(RecipientType.TO, new InternetAddress(emailSend.getTo()));
            msg.setText(emailSend.getMessage());
            msg.setSentDate(new Date());
            Transport.send(msg);
            return CompletableFuture.completedFuture(msg.isSet(Flag.RECENT));
            
        } catch (MessagingException e) {
            System.out.print("The message was not sent "+ e);
        }

        return CompletableFuture.completedFuture(false);



    }
}
