package com.kea.bilabonnement.model;

/**
 * Author Nazmul
 */

public class Customer extends Person{

    private String address;
    private String drivingLicense;
    private String passportNumber;
    private int phoneNumber;
    private int creditRating;
    private int creditCard;

    public Customer() {
    }

    // constructor without id
    public Customer(String name, int cprNumber, String username, String password, String address, String drivingLicense, String passportNumber, int phoneNumber, int creditRating, int creditCard) {
        super(name, cprNumber, username, password);
        this.address = address;
        this.drivingLicense = drivingLicense;
        this.passportNumber = passportNumber;
        this.phoneNumber = phoneNumber;
        this.creditRating = creditRating;
        this.creditCard = creditCard;
    }


    // all args constructor
    public Customer(int id, String name, int cprNumber, String username, String password, String address, String drivingLicense, String passportNumber, int phoneNumber, int creditRating, int creditCard) {
        super(id, name, cprNumber, username, password);
        this.address = address;
        this.drivingLicense = drivingLicense;
        this.passportNumber = passportNumber;
        this.phoneNumber = phoneNumber;
        this.creditRating = creditRating;
        this.creditCard = creditCard;
    }


    // getters and setters

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(int creditRating) {
        this.creditRating = creditRating;
    }

    public int getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(int creditCard) {
        this.creditCard = creditCard;
    }

    // to string

    @Override
    public String toString() {
        return "Customer{" +
                "address='" + address + '\'' +
                ", drivingLicense='" + drivingLicense + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", creditRating=" + creditRating +
                ", creditCard=" + creditCard +
                "} " + super.toString();
    }
}
