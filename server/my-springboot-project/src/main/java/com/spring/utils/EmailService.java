package com.spring.utils;

import org.springframework.stereotype.Service;

import com.spring.dto.EmailMessageDTO;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@Service
public class EmailService {

    /**
     * Send Email: SMTP
     */

    public String sendEmail(Email email) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.starttls.required", "true");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("kamrul.hassan@stonybrook.edu", "Fahim84590@123111402!");
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("kamrul.hassan@stonybrook.edu"));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(email.getTo()));
            message.setSubject(email.getSubject());
            message.setContent(email.getContent(), "text/html;charset=utf-8");
            Transport.send(message);
            return "Message sent successfully";
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public List<EmailMessageDTO> fetch(Folder folder) {
        FetchProfile profile = new FetchProfile();
        profile.add(FetchProfile.Item.CONTENT_INFO);

        try {
            List<EmailMessageDTO> emailMessageDTOList = new ArrayList<>();
            int start = 1;
            int end = folder.getMessageCount() / 2;

            Message[] messages = folder.getMessages(start, end);
            folder.fetch(messages, profile);
            for (Message message : messages) {
                Address[] from = message.getFrom();
                Address[] to = message.getAllRecipients();
                String subject = message.getSubject();
                String cc = message.getHeader("CC")[0];
                String bcc = message.getHeader("BCC")[0];
                Date sentDate = message.getSentDate();
                String body = message.getContent().toString();
                EmailMessageDTO emailMessageDTO = new EmailMessageDTO(from, to, subject, cc, bcc, sentDate, body);
                emailMessageDTOList.add(emailMessageDTO);
            }
            return emailMessageDTOList;
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<EmailMessageDTO> fetchEmails() {
        Properties prop = new Properties();
        prop.put("mail.store.protocol", "imaps");
        prop.put("mail.imaps.host", "imap.gmail.com");
        prop.put("mail.imaps.port", "993");
        prop.put("mail.imaps.ssl.enable", "true");
        prop.put("mail.imaps.ssl.protocols", "TLSv1.2");
        prop.put("mail.imaps.ssl.trust", "*");

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("kamrul.hassan@stonybrook.edu", "Fahim84590@123111402!");
            }
        });

        try {
            Store store = session.getStore("imaps");
            store.connect("kamrul.hassan@stonybrook.edu", "Fahim84590@123111402!");
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
            return fetch(inbox);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }

}