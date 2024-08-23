package com.spring.service.Email;

import com.spring.dto.Email;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.FetchProfile.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;

@Service
public class EmailService {

    @Async
    public CompletableFuture<List<Email>> fetchEmail(int start, int end) {
        

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





        List<Email> emails = new ArrayList<>();
        try{

        Store store = session.getStore("imaps");
        store.connect("imap.gmail.com", "kamrul.hassan@stonybrook.edu", "Fahim84590@123111402!");
        Folder folder = store.getFolder("INBOX");
        folder.open(Folder.READ_ONLY);

        FetchProfile profile = new FetchProfile();
        profile.add(Item.ENVELOPE);

        Message [] messages = folder.getMessages(start, end);
        
        folder.fetch(messages, profile);

        for(Message message: messages){

            if(message.getSubject() != null || message.getSubject().length() != 0){
                String subject = message.getSubject().toString();
                String from = message.getFrom().toString();
                emails.add(new Email(subject, from));
            }

        }

        for (Email e: emails){
            System.out.print(e);
        }

        return CompletableFuture.completedFuture(emails);
        
        }catch(MessagingException messagingException){
            System.out.print(messagingException);
        }

     return null;   
    }

 
}
