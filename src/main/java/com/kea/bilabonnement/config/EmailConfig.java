package com.kea.bilabonnement.config;

import org.springframework.context.annotation.Configuration;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

/**
 * Author Nazmul
 */

@Configuration
public class EmailConfig {

    // get email and password from system environment
    private final String emailAddress = System.getenv("email.address");
    private final String emailPassword = System.getenv("email.password");

    // getter
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * method to set and return email properties
     * @return
     */
    private Properties getEmailProperties(){
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.dk");
        properties.put("mail.smtp.port", "587");
        return properties;
    }

    /**
     * Method to verify username and password and return a session
     * @return
     */
    public Session getEmailSession() {
        Session session = Session.getInstance(getEmailProperties(), new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailAddress, emailPassword);
            }
        });
        return session;
    }




}
