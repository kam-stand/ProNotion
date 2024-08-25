package com.spring.dto;

public class EmailSend {

   private String message; 
   private String to; 
   private String subject;

public String getMessage() {
    return message;
}
public void setMessage(String message) {
    this.message = message;
}
public String getTo() {
    return to;
}
public void setTo(String to) {
    this.to = to;
}
public String getSubject() {
    return subject;
}
public void setSubject(String subject) {
    this.subject = subject;
}
public EmailSend(String message, String to, String subject) {
    this.message = message;
    this.to = to;
    this.subject = subject;
}



    
}
