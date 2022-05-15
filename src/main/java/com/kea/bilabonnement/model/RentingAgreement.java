package com.kea.bilabonnement.model;

import java.util.List;

public class RentingAgreement {

    private int agreementNumber;
    private int price;
    private String description;
    private int customerId;
    private int carRegNumber;
    private int employeeId;

    public RentingAgreement(){

    }

    public RentingAgreement(int agreementNumber, int price, String description, int customerId, int carRegNumber, int employeeId){
        this.agreementNumber = agreementNumber;
        this.price = price;
        this.description = description;
        this.customerId = customerId;
        this.carRegNumber = carRegNumber;
        this.employeeId = employeeId;
    }

    public int getAgreementNumber(){
        return agreementNumber;
    }
    public void setAgreementNumber(int agreementNumber){
        this.agreementNumber = agreementNumber;
    }
    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public int getCustomerId(){
        return customerId;
    }
    public void setCustomerId(int customerId){
        this.customerId = customerId;
    }
    public int getCarRegNumber(){
        return carRegNumber;
    }
    public void setCarRegNumber(int carRegNumber){
        this.carRegNumber = carRegNumber;
    }
    public int getEmployeeId(){
        return employeeId;
    }
    public void setEmployeeId(int employeeId){
        this.employeeId = employeeId;
    }

    @Override
    public String toString(){
        return "Renting Agreement" +
                "Agreement Number = " + agreementNumber +
                ", Price = " + price +
                ", Description = " + description +
                ", Customer Id = " + customerId +
                ", Car Reg Number = " + carRegNumber +
                ", Employee Id = " + employeeId;
    }
}
