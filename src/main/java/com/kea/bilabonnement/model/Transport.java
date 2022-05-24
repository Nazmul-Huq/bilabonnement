package com.kea.bilabonnement.model;

import java.sql.Date;

/**
 * Author Nazmul
 */

public class Transport {

    private int id;
    private Date pickupDate;
    private String pickupLocation;
    private String deliveryLocation;
    private Date deliveryDeadline;
    private String note;
    private Date deliveryDate; // initially will be null, later when a car is delivered the date wil set
    private int carRegNumber;

    //default constructor
    public Transport() {
    }

    // constructor without id attributes

    public Transport(Date pickupDate, String pickupLocation, String deliveryLocation, Date deliveryDeadline, String note, Date deliveryDate, int carRegNumber) {
        this.pickupDate = pickupDate;
        this.pickupLocation = pickupLocation;
        this.deliveryLocation = deliveryLocation;
        this.deliveryDeadline = deliveryDeadline;
        this.note = note;
        this.deliveryDate = deliveryDate;
        this.carRegNumber = carRegNumber;
    }

    // constructor with all attributes


    public Transport(int id, Date pickupDate, String pickupLocation, String deliveryLocation, Date deliveryDeadline, String note, Date deliveryDate, int carRegNumber) {
        this.id = id;
        this.pickupDate = pickupDate;
        this.pickupLocation = pickupLocation;
        this.deliveryLocation = deliveryLocation;
        this.deliveryDeadline = deliveryDeadline;
        this.note = note;
        this.deliveryDate = deliveryDate;
        this.carRegNumber = carRegNumber;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDeliveryLocation() {
        return deliveryLocation;
    }

    public void setDeliveryLocation(String deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }

    public Date getDeliveryDeadline() {
        return deliveryDeadline;
    }

    public void setDeliveryDeadline(Date deliveryDeadline) {
        this.deliveryDeadline = deliveryDeadline;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public int getCarRegNumber() {
        return carRegNumber;
    }

    public void setCarRegNumber(int carRegNumber) {
        this.carRegNumber = carRegNumber;
    }

    //to string

    @Override
    public String toString() {
        return "Transport{" +
                "id=" + id +
                ", pickupDate=" + pickupDate +
                ", pickupLocation='" + pickupLocation + '\'' +
                ", deliveryLocation='" + deliveryLocation + '\'' +
                ", deliveryDeadline=" + deliveryDeadline +
                ", note='" + note + '\'' +
                ", deliveryDate=" + deliveryDate +
                ", carRegNumber=" + carRegNumber +
                '}';
    }
} // class ends here
