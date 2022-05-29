package com.kea.bilabonnement.model;

/**
 * Author Nazmul
 */

public class Booking {

    private int id;
    private int carRegNumber;
    private int customerId;

    public Booking() {
    }

    public Booking(int carRegNumber, int customerId) {
        this.carRegNumber = carRegNumber;
        this.customerId = customerId;
    }

    public Booking(int id, int carRegNumber, int customerId) {
        this.id = id;
        this.carRegNumber = carRegNumber;
        this.customerId = customerId;
    }

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

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", carRegNumber=" + carRegNumber +
                ", customerId=" + customerId +
                '}';
    }
}
