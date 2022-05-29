package com.kea.bilabonnement.model;

/**
 * Author Nazmul
 */

public class Booking {

    private int id;
    private int carRegNumber;
    private int customerId;

    // default constructor
    public Booking() {
    }

    // constructor without id
    public Booking(int carRegNumber, int customerId) {
        this.carRegNumber = carRegNumber;
        this.customerId = customerId;
    }

    // all args constructor
    public Booking(int id, int carRegNumber, int customerId) {
        this.id = id;
        this.carRegNumber = carRegNumber;
        this.customerId = customerId;
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCarRegNumber() {
        return carRegNumber;
    }

    public void setCarRegNumber(int carRegNumber) {
        this.carRegNumber = carRegNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    // to string
    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", carRegNumber=" + carRegNumber +
                ", customerId=" + customerId +
                '}';
    }
}
