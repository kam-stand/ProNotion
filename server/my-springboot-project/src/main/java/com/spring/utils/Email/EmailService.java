package com.spring.utils.Email;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;

import javax.mail.Authenticator;
import javax.mail.FetchProfile;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.spring.dto.EmailResponseDto;

@Service
public class EmailService {

    /**
     * Fetch the email from the server
     */
    @Async
    public CompletableFuture<List<EmailResponseDto>> fetchEmails() {
        List<EmailResponseDto> emailResponseDtoList = new ArrayList<>();
        try {
            Properties prop = new Properties();
            prop.put("mail.store.protocol", "imaps");
            prop.put("mail.imaps.host", "imap.gmail.com");
            prop.put("mail.imaps.port", "993");
            prop.put("mail.imaps.ssl.enable", "true");
            prop.put("mail.imaps.ssl.protocols", "TLSv1.2");
            prop.put("mail.imaps.ssl.trust", "*");

            Session emailSession = Session.getInstance(prop, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("kamrul.hassan@stonybrook.edu", "Fahim84590@123111402!");
                }
            });

            FetchProfile profile = new FetchProfile();
            profile.add(FetchProfile.Item.ENVELOPE);

            Store store = emailSession.getStore("imaps");
            store.connect("kamrul.hassan@stonybrook.edu", "Fahim84590@123111402!");

            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            emailFolder.fetch(emailFolder.getMessages(), profile);

            for (Message message : emailFolder.getMessages()) {
                EmailResponseDto emailResponseDto = new EmailResponseDto();
                emailResponseDto.setSubject(message.getSubject());
                emailResponseDto.setFrom(message.getFrom()[0].toString());
                emailResponseDto.setSentDate(message.getSentDate());
                emailResponseDtoList.add(emailResponseDto);
            }

            emailFolder.close(false);
            store.close();

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(emailResponseDtoList);
    }

    public List<Message> fetchMessages() {
        List<Message> messages = new ArrayList<>();
        try {
            Properties prop = new Properties();
            prop.put("mail.store.protocol", "imaps");
            prop.put("mail.imaps.host", "imap.gmail.com");
            prop.put("mail.imaps.port", "993");
            prop.put("mail.imaps.ssl.enable", "true");
            prop.put("mail.imaps.ssl.protocols", "TLSv1.2");
            prop.put("mail.imaps.ssl.trust", "*");

            Session emailSession = Session.getInstance(prop, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("kamrul.hassan@stonybrook.edu", "Fahim84590@123111402!");
                }
            });

            Store store = emailSession.getStore("imaps");
            store.connect("kamrul.hassan@stonybrook.edu", "Fahim84590@123111402!");

            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            for (Message message : emailFolder.getMessages()) {
                messages.add(message);
            }

            emailFolder.close(false);
            store.close();

        } catch (MessagingException e) {
            e.printStackTrace();

        }
        return messages;

    }
}