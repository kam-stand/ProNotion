package com.spring.service.Email;

import com.spring.dto.Email;

import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.FetchProfile.Item;
import java.util.ArrayList;
import java.util.Collections;
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

        return CompletableFuture.completedFuture(emails);
        
        }catch(MessagingException messagingException){
            System.out.print(messagingException);
        }

     return null;   
    }

@Async
public CompletableFuture<List<String>> getEmails(String username, String password) {
    SecurityContext context = SecurityContextHolder.getContext();
    return CompletableFuture.supplyAsync(() -> {
        SecurityContextHolder.setContext(context);

        EmailProtocol emailProtocol = new EmailProtocol(username, password);
        List<String> fromList = new ArrayList<>();
        Session imapSession = emailProtocol.ImapSession();

        try  {
            Store store = imapSession.getStore("imaps");
            store.connect(username, password);
            Folder inboxFolder = store.getFolder("INBOX");
            inboxFolder.open(Folder.READ_WRITE);

            Message[] messages = inboxFolder.getMessages();
            for (Message m : messages) {
                Address[] fromAddresses = m.getFrom();
                if (fromAddresses != null) {
                    for (Address address : fromAddresses) {
                        fromList.add(address.toString());
                    }
                }
            }
            inboxFolder.close(false);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fromList;
    });
}



@Async
public CompletableFuture<String> testEmails(String username, String pasword){

    return CompletableFuture.supplyAsync(
        () -> {
            EmailProtocol emailProtocol = new EmailProtocol(username, pasword);
        Session imapSession = emailProtocol.ImapSession();
        try {
            Store store = imapSession.getStore("imaps");
            store.connect(username, pasword);
            Folder inboxFolder = store.getFolder("INBOX");
            inboxFolder.open(Folder.READ_ONLY);

            Message [] messages = inboxFolder.getMessages();
            for(Message m: messages){
                System.out.print(m.getFrom());
            }

            return "helloword";



            
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return "world";
        }

    );

}

@Async
public CompletableFuture<List<String>> getAsyncFrom(String username, String password) {
    SecurityContext context = SecurityContextHolder.getContext();
    return CompletableFuture.supplyAsync(() -> {
        SecurityContextHolder.setContext(context);
        return getFrom(username, password);
    });
}


public List<String> getFrom(String username, String password) {
    try {
        EmailProtocol emailProtocol = new EmailProtocol(username, password);
        Session imapSession = emailProtocol.ImapSession();

        Store store = imapSession.getStore("imaps");
        store.connect(username, password);
        Folder inboxFolder = store.getFolder("INBOX");
        inboxFolder.open(Folder.READ_ONLY);

        Message[] messages = inboxFolder.getMessages();

        List<String> from = new ArrayList<>();
        for (Message m : messages) {
            from.add(m.getFrom()[0].toString()); // Access the first sender's address
        }

        inboxFolder.close(false);
        store.close();

        return from;

    } catch (Exception e) {
        e.printStackTrace();
    }
    return Collections.emptyList(); // Return an empty list if an error occurs
}



    }





 

