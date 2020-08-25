package com.ui.spring.springboot2jpacrudexample;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailConfiguration {
	
	
	static final String username = "info@frangipanibookstest.com";
	static final String passwd = "Frangipani@123"; 
	static Session session  = null;
	 
 	public static Session mailConfiguration() {
 		
 		Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.frangipanibookstest.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "3306");
        props.put("mail.smtp.starttls.enable", "true");
 		 
        return session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, passwd);
            }
        });
 	}
	 
    public static void sendMail(String subject,String body) {
        final String from = "info@frangipanibookstest.com";
        session = mailConfiguration();
        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            msg.setRecipients(Message.RecipientType.TO,"info@frangipanibookstest.com");
            msg.setRecipients(Message.RecipientType.BCC,"shah.ankitmca@gmail.com");
            //msg.setReplyTo(new InternetAddress[]{new InternetAddress("noreply@infoanalytica.com")});
            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msg.setContent(body, "text/html; charset=utf-8");
            Transport.send(msg);
            System.out.println("send failed, done: " );
        } catch (MessagingException e) {
            System.out.println("send failed, exception: " + e);
        }
        System.out.println("Sent Ok") ;
    }
}
