 
package com.spring.service.Email;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

import java.util.Properties;
import javax.mail.Session;

import org.springframework.stereotype.Component;

@Component
public class EmailProtocol {


    private String username;

    private String password;


EmailProtocol (){

}

EmailProtocol(String username, String password){
    this.password=password;
    this.username = username;
}

public String getUsername() {
    return username;
}

public void setUsername(String username) {
    this.username = username;
}

public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}

public Session ImapSession(){
    Properties props = new Properties();
    props.put("mail.store.protocol", "imaps");
    props.put("mail.imaps.host", "imap.gmail.com");
    props.put("mail.imaps.port", "993");
    props.put("mail.imaps.ssl.enable", "true");
    props.put("mail.imaps.ssl.protocols", "TLSv1.2");
    props.put("mail.imaps.ssl.trust", "*");

    return createSession(props);

}


public Session SmtpSession(){

    Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtp.port", "587"); //TLS Port
		props.put("mail.smtp.auth", "true"); //enable authentication
		props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
		
    return createSession(props);
    

}


private Session createSession(Properties props){
    Session session = Session.getInstance(props, new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
        }
    });
    return session;

}


    
}