package com.example.fuelcap;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Session;
import javax.mail.Transport;


public class GMail {

    // Settings so Gmail will work.
    final String emailPort = "587";
    final String smtpAuth = "true";
    final String starttls = "true";
    final String emailHost = "smtp.gmail.com";

    String fEmail;
    String fPassword;
    List<String> tEmailList;
    String mailSub;
    String mailBody;

    Properties emailProperties;
    Session mailSession;
    MimeMessage emailMessage;

    public GMail(String fEmail, String fPassword, List<String> tEmailList, String mailSub, String mailBody)
    {
        this.fEmail = fEmail;
        this.fPassword = fPassword;
        this.tEmailList = tEmailList;
        this.mailSub = mailSub;
        this.mailBody = mailBody;

        //setting the server settings for Gmail
        emailProperties = System.getProperties();
        emailProperties.put("mail.smtp.port", emailPort);
        emailProperties.put("mail.smtp.auth", smtpAuth);
        emailProperties.put("mail.smtp.starttls.enable", starttls);
        Log.i("Gmail", "The server's properties for Mail are set now.");
    }

    public MimeMessage createEmailMessage() throws AddressException,
            MessagingException, UnsupportedEncodingException {

        mailSession = Session.getDefaultInstance(emailProperties, null);
        emailMessage = new MimeMessage(mailSession);

        emailMessage.setFrom(new InternetAddress(fEmail, fEmail));//setting up address
        for(String tEmail : tEmailList){
            Log.i("Gmail", "tEmail" + tEmail);
            emailMessage.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(tEmail));
        }

        emailMessage.setSubject(mailSub);
        emailMessage.setContent(mailBody, "text/html");
        Log.i("Gmail", "Your mail message has been created.");
        return emailMessage;

    }

    public void sendEmail() throws AddressException, MessagingException
    {
        Transport transport = mailSession.getTransport("smtp");
        transport.connect(emailHost, fEmail, fPassword);
        Log.i("Gmail", "All Recipients" + emailMessage.getAllRecipients());
        transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
        transport.close();
        Log.i("Gmail", "Your mail message has been sent gloriously" );
    }
}
