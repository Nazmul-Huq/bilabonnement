package com.kea.bilabonnement.model;

import java.util.Date;

/**
 * Author Nazmul
 */

public class Transport {

    private int id;
    private String description;
    private Date startTime;
    private Date deliveryTime;
    private int carRegNumber;

    //default constructor
    public Transport() {
    }

    // constructor without id attributes
    public Transport(String description, Date startTime, Date deliveryTime, int carRegNumber) {
        this.description = description;
        this.startTime = startTime;
        this.deliveryTime = deliveryTime;
        this.carRegNumber = carRegNumber;
    }

    // constructor with all attributes
    public Transport(int id, String description, Date startTime, Date deliveryTime, int carRegNumber) {
        this.id = id;
        this.description = description;
        this.startTime = startTime;
        this.deliveryTime = deliveryTime;
        this.carRegNumber = carRegNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public int getCarRegNumber() {
        return carRegNumber;
    }

    public void setCarRegNumber(int carRegNumber) {
        this.carRegNumber = carRegNumber;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", startTime=" + startTime +
                ", deliveryTime=" + deliveryTime +
                ", carRegNumber=" + carRegNumber +
                '}';
    }

} // class ends here
