package com.kea.bilabonnement.model;

/**
 * Author Nazmul
 */

public class AlarmMessage {
    private String emailRecipient;
    private String emailCc;
    private String emailSubject;
    private Alarm alarm;
    private String comment;

    // default constructor
    public AlarmMessage() {
    }

    // all args constructor
    public AlarmMessage(String emailRecipient, String emailCc, String emailSubject, Alarm alarm, String comment) {
        this.emailRecipient = emailRecipient;
        this.emailCc = emailCc;
        this.emailSubject = emailSubject;
        this.alarm = alarm;
        this.comment = comment;
    }

    // getters and setters
    public String getEmailRecipient() {
        return emailRecipient;
    }

    public void setEmailRecipient(String emailRecipient) {
        this.emailRecipient = emailRecipient;
    }

    public String getEmailCc() {
        return emailCc;
    }

    public void setEmailCc(String emailCc) {
        this.emailCc = emailCc;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public Alarm getAlarm() {
        return alarm;
    }

    public void setAlarm(Alarm alarm) {
        this.alarm = alarm;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    // to string
    @Override
    public String toString() {
        return "AlarmMessage{" +
                "emailRecipient='" + emailRecipient + '\'' +
                ", emailCc='" + emailCc + '\'' +
                ", emailSubject='" + emailSubject + '\'' +
                ", alarm=" + alarm +
                ", comment='" + comment + '\'' +
                '}';
    }
} // class ends here
