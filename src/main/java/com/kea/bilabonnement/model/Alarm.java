package com.kea.bilabonnement.model;

import com.kea.bilabonnement.enums.AlarmType;

import java.util.Date;

/**
 * Author Nazmul
 */

public class Alarm {

    private int id;
    private String alarmDescription;
    private Date alarmDate;
    private String alarmReceiver;
    private AlarmType alarmType;
    private int carRegNumber;

    // default constructor
    public Alarm() {
    }

    // constructor without id
    public Alarm(String alarmDescription, Date alarmDate, String alarmReceiver, AlarmType alarmType, int carRegNumber) {
        this.alarmDescription = alarmDescription;
        this.alarmDate = alarmDate;
        this.alarmReceiver = alarmReceiver;
        this.alarmType = alarmType;
        this.carRegNumber = carRegNumber;
    }

    // constructor with all paramenter
    public Alarm(int id, String alarmDescription, Date alarmDate, String alarmReceiver, AlarmType alarmType, int carRegNumber) {
        this.id = id;
        this.alarmDescription = alarmDescription;
        this.alarmDate = alarmDate;
        this.alarmReceiver = alarmReceiver;
        this.alarmType = alarmType;
        this.carRegNumber = carRegNumber;
    }

    // getters and setters for all attribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlarmDescription() {
        return alarmDescription;
    }

    public void setAlarmDescription(String alarmDescription) {
        this.alarmDescription = alarmDescription;
    }

    public Date getAlarmDate() {
        return alarmDate;
    }

    public void setAlarmDate(Date alarmDate) {
        this.alarmDate = alarmDate;
    }

    public String getAlarmReceiver() {
        return alarmReceiver;
    }

    public void setAlarmReceiver(String alarmReceiver) {
        this.alarmReceiver = alarmReceiver;
    }

    public AlarmType getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(AlarmType alarmType) {
        this.alarmType = alarmType;
    }

    public int getCarRegNumber() {
        return carRegNumber;
    }

    public void setCarRegNumber(int carRegNumber) {
        this.carRegNumber = carRegNumber;
    }

    // to string
    @Override
    public String toString() {
        return "Alarm{" +
                "id=" + id +
                ", alarmDescription='" + alarmDescription + '\'' +
                ", alarmDate=" + alarmDate +
                ", alarmReceiver='" + alarmReceiver + '\'' +
                ", alarmType='" + alarmType + '\'' +
                ", carRegNumber=" + carRegNumber +
                '}';
    }

} // class ends here
