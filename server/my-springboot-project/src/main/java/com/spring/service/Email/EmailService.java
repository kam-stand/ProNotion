package com.spring.service.Email;

import org.springframework.stereotype.Service;

import javax.mail.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Service
public class EmailService {

    /**
     * 1. Connect to the email using username and password
     * 2. Fetch the email one by one and then put them into an array object
     *
     */

    public List<String> fetchEmail(String username, String password) {
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
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // create a store and connect to the database
            Store store = session.getStore("imaps");
            store.connect(username, password);
            Folder inbox = store.getFolder("INBOX");
            List<String> subjectList = new ArrayList<>();
            inbox.open(Folder.READ_WRITE);
            FetchProfile fetchProfile = new FetchProfile();
            fetchProfile.add(FetchProfile.Item.ENVELOPE);
            Message[] messages = inbox.getMessages();
            inbox.fetch(messages, fetchProfile);

            for (Message message : messages) {
                String subject = message.getSubject();
                if (subject == null || subject.isEmpty()) {
                    subject = "Empty";
                }
                subjectList.add(subject);
            }

            for (String s : subjectList) {
                System.out.println(s);
            }
            store.close();
            return subjectList;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
