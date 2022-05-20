package com.kea.bilabonnement.controller;

import com.kea.bilabonnement.config.EmailConfig;
import com.kea.bilabonnement.enums.AlarmType;
import com.kea.bilabonnement.model.Alarm;
import com.kea.bilabonnement.model.AlarmMessage;
import com.kea.bilabonnement.service.SendMessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author Nazmul
 */

@Controller
@RequestMapping("/send-message")
public class SendMessageController {

    // instantiate necessary objects
    EmailConfig emailConfig = new EmailConfig();
    SendMessageService sendMessageService = new SendMessageService(emailConfig);


    /**
     * this method accept post request to send an email
     * then it returns a view (form) where user can edit data before sending the email
     * @param alarmDescription
     * @param alarmDate
     * @param alarmReceiver
     * @param alarmType
     * @param carRegNumber
     * @param model
     * @return
     * @throws ParseException
     */
    @PostMapping("/send-email")
    public String sendEmail(
            @RequestParam String alarmDescription,
            @RequestParam String alarmDate,
            @RequestParam String alarmReceiver,
            @RequestParam String alarmType,
            @RequestParam int carRegNumber,
            Model model
    ) throws ParseException {

        // convert text to date
        Date date = new Date();
        try {
            date = new SimpleDateFormat("dd-MM-yyyy").parse(alarmDate);
        } catch (ParseException parseException){
            date = new Date();
        }

        // create an Alarm (It is better if form send an Alarm model, will try to implement later)
        Alarm alarm = new Alarm(alarmDescription, date, alarmReceiver, AlarmType.valueOf(alarmType), carRegNumber);

        model.addAttribute("alarm", alarm);
        return "/send-message/email-form";
    }


    /**
     * this method handle the final sending of the email
     * @param emailRecipient
     * @param emailCc
     * @param emailSubject
     * @param alarmDescription
     * @param alarmDate
     * @param alarmReceiver
     * @param alarmType
     * @param carRegNumber
     * @param comment
     * @return
     */
    @PostMapping("/send-email-handler")
    public String sendEmailHandler(
            @RequestParam String emailRecipient,
            @RequestParam String emailCc,
            @RequestParam String emailSubject,
            @RequestParam String alarmDescription,
            @RequestParam String alarmDate,
            @RequestParam String alarmReceiver,
            @RequestParam String alarmType,
            @RequestParam int carRegNumber,
            @RequestParam String comment

    ) {

        // convert string to date
        Date date = new Date();
        try {
            date = new SimpleDateFormat("dd-MM-yyyy").parse(alarmDate);
        } catch (ParseException parseException){
            date = new Date();
        }

        // create an Alarm (It is better if form send an Alarm model, will try to implement later)
        Alarm alarm = new Alarm(alarmDescription, date, alarmReceiver, AlarmType.valueOf(alarmType), carRegNumber);

        // make an alarm message
        AlarmMessage alarmMessage = new AlarmMessage(emailRecipient, emailCc, emailSubject, alarm, comment);
        try{
            // send the email
           sendMessageService.sendAlarmByEmail(alarmMessage);
            return "/send-message/message-sent-success";
        }  catch (MessagingException messagingException){
            return "/send-message/message-sent-fail";
        } catch (IOException ioException){
            return "/send-message/message-sent-fail";
        }
    }

} // class ends here
