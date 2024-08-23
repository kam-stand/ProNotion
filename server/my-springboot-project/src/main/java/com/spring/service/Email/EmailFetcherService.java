package com.spring.service.Email;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.Authenticator;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.SubjectTerm;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;

@Service
public class EmailFetcherService {

 

    @Async
    public CompletableFuture<List<String>> fetchEmailSubjectsAsync(String host, String username, String password, String folderName) {
        return CompletableFuture.supplyAsync(() -> {
            List<String> subjects = new ArrayList<>();

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
                Store store = session.getStore("imap");
                store.connect(host, username, password);

                Folder folder = store.getFolder(folderName);
                folder.open(Folder.READ_ONLY);

                Message[] messages = folder.search(new SubjectTerm("your search term"));

                for (Message message : messages) {
                    subjects.add(message.getSubject());
                }

                folder.close(false);
                store.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            for(String s: subjects){
                System.out.print(s);
            }

            return subjects;
        });
    }
}