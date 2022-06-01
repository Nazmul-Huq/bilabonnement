package com.kea.bilabonnement.model;

import java.sql.Date;
import java.util.List;

/**Written by Søs**/
public class RentingAgreement {

    private int agreementNumber;
    private int price;
    private String description;
    private String type;
    private int customerId;
    private int carRegNumber;
    private int employeeId;
    private boolean rentingStatus;
    private Date agreementDate;
    private Date endingDate;



    public RentingAgreement(){

    }

    public RentingAgreement(int agreementNumber, int price, String description, String type, int customerId, int carRegNumber, int employeeId, boolean rentingStatus, Date agreementDate, Date endingDate) {
        this.agreementNumber = agreementNumber;
        this.price = price;
        this.description = description;
        this.type = type;
        this.customerId = customerId;
        this.carRegNumber = carRegNumber;
        this.employeeId = employeeId;
        this.rentingStatus = rentingStatus;
        this.agreementDate = agreementDate;
        this.endingDate = endingDate;

    }

    //Constructor without agreementNumber for "make renting agreement"
    public RentingAgreement(int price, String description, String type, int customerId, int carRegNumber, int employeeId, boolean rentingStatus, Date agreementDate) {
        this.price = price;
        this.description = description;
        this.type = type;
        this.customerId = customerId;
        this.carRegNumber = carRegNumber;
        this.employeeId = employeeId;
        this.rentingStatus = rentingStatus;
        this.agreementDate = agreementDate;
    }

    //Constructor for "endRentingAgreement"
    public RentingAgreement(int agreementNumber, int carRegNumber, int customerId, String description, int employeeId, Date endingDate, boolean rentingStatus) {
        this.agreementNumber = agreementNumber;
        this.carRegNumber = carRegNumber;
        this.customerId = customerId;
        this.description = description;
        this.employeeId = employeeId;
        this.endingDate = endingDate;
        this.rentingStatus = rentingStatus;
    }

    //Constructor for "overviewOfPayments"
    public RentingAgreement(int carRegNumber, int price){
        this.carRegNumber = carRegNumber;
        this.price = price;
    }

    //Constructor for "getTotalPayment"
    public RentingAgreement(int price){
        this.price = price;
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
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
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
    public Date getEndingDate(){
        return endingDate;
    }
    public void setEndingDate(Date endingDate){
        this.endingDate = endingDate;
    }
    public boolean isRentingStatus() {
        return rentingStatus;
    }
    public void setRentingStatus(boolean rentingStatus){
        this.rentingStatus = rentingStatus;
    }
    public Date getAgreementDate(){
        return agreementDate;
    }
    public void setAgreementDate(){
        this.agreementDate = agreementDate;
    }

    @Override
    public String toString(){
        return "Renting Agreement" +
                "Agreement Number = " + agreementNumber +
                ", Price = " + price +
                ", Description = " + description +
                ", Customer Id = " + customerId +
                ", Car Reg Number = " + carRegNumber +
                ", Employee Id = " + employeeId +
                ", Ending Date" + endingDate +
                ", Renting Status" + rentingStatus +
                ", Agreement Date" + agreementDate;
    }
}
