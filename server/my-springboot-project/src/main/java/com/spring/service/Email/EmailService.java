package com.spring.service.Email;

import com.spring.dto.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.FetchProfile.Item;

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


    public List<Email> fetchEmail(String username, String password) {
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


        return null;


        
    }


    public Store connection(String username, String password, EmailProtocol emailProtocol, boolean send){
        Session session = null;

        if(send){
            session= emailProtocol.SmtpSession();
        }


        session = emailProtocol.ImapSession();
        Store store;
        try {
            store = session.getStore("imaps");
            store.connect(username, password);
            
            return store;
        } catch (MessagingException e) {
            e.printStackTrace();

        }
        return null;
    
    }

    public Folder openFolder(Store store, int Start, int end) throws MessagingException{

        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);

        FetchProfile fetchProfile = new FetchProfile();
        fetchProfile.add(Item.ENVELOPE);
        fetchProfile.add(Item.CONTENT_INFO);


        Message [] messages = inbox.getMessages(Start,end);
        inbox.fetch(messages, fetchProfile);

        return inbox;
        
    }


    @Async
    public Comparable<List<Email>> emailList(Folder inbox) throws MessagingException{

        List<Email> emailList = new ArrayList<>();

        for(Message message: inbox.getMessages()){
            
        }


        return null;

    
    }




    
}
