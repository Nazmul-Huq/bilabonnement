package com.kea.bilabonnement.service;

import com.kea.bilabonnement.config.EmailConfig;
import com.kea.bilabonnement.model.Alarm;
import com.kea.bilabonnement.model.AlarmMessage;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Date;

/**
 * Author Nazmul
 */

public class SendMessageService {

    // instantiate necessary object
    EmailConfig emailConfig;

    public SendMessageService(EmailConfig emailConfig) {
        this.emailConfig = emailConfig;
    }

    //public boolean sendAlarmByEmail(String emailRecipient, Alarm alarm) throws AddressException, MessagingException, IOException {
    public boolean sendAlarmByEmail(AlarmMessage alarmMessage) throws AddressException, MessagingException, IOException {

        // create email body content
        String bodyContent = "Du har modtaget denne mail vedr. "
                + " Car Registration number: " + alarmMessage.getAlarm().getCarRegNumber()
                + " Problem Beskrivelse: " + alarmMessage.getAlarm().getAlarmDescription()
                + " Note: " + alarmMessage.getComment()
                + " For more info please contact to: " + alarmMessage.getAlarm().getAlarmReceiver();

        Message msg = new MimeMessage(emailConfig.getEmailSession());
        msg.setFrom(new InternetAddress(emailConfig.getEmailAddress(), false));

        // set recipients and cc
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(alarmMessage.getEmailRecipient()));
        if (alarmMessage.getEmailCc() != null && alarmMessage.getEmailCc().length() > 0) {
            msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(alarmMessage.getEmailCc()));
        }

        // set email subject
        msg.setSubject(alarmMessage.getEmailSubject());

        // st email content
        msg.setContent(bodyContent, "text/html");

        msg.setSentDate(new Date());
        Transport.send(msg);
        return true;
    }


} // class ends here
