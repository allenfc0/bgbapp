package com.bakerygb.bgbapp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.io.IOException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

@Controller
public class ContactController {

    @PostMapping({"/sendEmail"})
    public String getEmail(@RequestParam("email") String email,
                            @RequestParam("title") String title,
                            @RequestParam("message") String message) throws MessagingException, IOException {

        //System.out.println(  email.getClass() + title + message);
        sendEmail(email, title, message);
        return "redirect:/contact";
    }


    private void sendEmail(String fromEmail, String subject, String message) throws AddressException, MessagingException, IOException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("allenfarias30@gmail.com", "16dpr0887l");
            }
        });

        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(fromEmail));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("allenfarias30@gmail.com"));
        msg.setSubject(subject);
        msg.setText(message);
        msg.setSentDate(new Date());


        //---------Adding attachments to the email but not needed for now
        /*MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("Tutorials point email", "text/html");


        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        MimeBodyPart attachPart = new MimeBodyPart();

        attachPart.attachFile("/var/tmp/image19.png");
        multipart.addBodyPart(attachPart);
        msg.setContent(multipart);*/
        Transport.send(msg);
    }
}



















