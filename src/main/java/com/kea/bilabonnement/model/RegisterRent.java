package com.kea.bilabonnement.model;

import java.util.Date;

/**Written by Søs**/
public class RegisterRent {

    private int id;
    private String location;
    private double drivenPickupKm;
    private Date pickupDate;
    private double drivenReturnKm;
    private Date returnDate;
    private String conditionReport;
    private int carRegNumber;
    private int customerId;
    private int employeeId;

    public RegisterRent() {
    }

    public RegisterRent(String location, int id, double drivenPickupKm, Date pickupDate, double drivenReturnKm, Date returnDate, String conditionReport, int carRegNumber, int customerId, int employeeId) {
        this.location = location;
        this.id = id;
        this.drivenPickupKm = drivenPickupKm;
        this.pickupDate = pickupDate;

        this.drivenReturnKm = drivenReturnKm;
        this.returnDate = returnDate;
        this.conditionReport = conditionReport;
        this.carRegNumber = carRegNumber;
        this.customerId = customerId;
        this.employeeId = employeeId;

    }
    //Constructor for "registerReturnedCar"
    public RegisterRent(int carRegNumber, double drivenReturnKm, String conditionReport, java.sql.Date returnDate, int employeeId){
        this.carRegNumber = carRegNumber;
        this.drivenReturnKm = drivenReturnKm;
        this.conditionReport = conditionReport;
        this.returnDate = returnDate;
        this.employeeId = employeeId;
    }

    //Constructor for "registerPickupCar"
    public RegisterRent(String location, int carRegNumber, double drivenPickupKm, String conditionReport, java.sql.Date pickupDate, int employeeId){
        this.location = location;
        this.carRegNumber = carRegNumber;
        this.drivenPickupKm = drivenPickupKm;
        this.conditionReport = conditionReport;
        this.pickupDate = pickupDate;
        this.employeeId = employeeId;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getLocation(){
        return location;
    }
    public void setLocation(String location){
        this.location = location;
    }
    public double getDrivenPickupKm(){
        return drivenPickupKm;
    }
    public void setDrivenPickupKm(double drivenPickupKm){
        this.drivenPickupKm = drivenPickupKm;
    }
    public Date getPickupDate(){
        return pickupDate;
    }
    public void setPickupDate(Date pickupDate){
        this.pickupDate = pickupDate;
    }
    public double getDrivenReturnKm(){
        return drivenReturnKm;
    }
    public void setDrivenReturnKm(double drivenReturnKm){
        this.drivenReturnKm = drivenReturnKm;
    }
    public Date getReturnDate(){
        return returnDate;
    }
    public void setReturnDate(Date returnDate){
        this.returnDate = returnDate;
    }
    public String getConditionReport(){
        return conditionReport;
    }
    public void setConditionReport(String conditionReport){
        this.conditionReport = conditionReport;
    }
    public int getCarRegNumber(){
        return carRegNumber;
    }
    public void setCarRegNumber(int carRegNumber){
        this.carRegNumber = carRegNumber;
    }
    public int getCustomerId(){
        return customerId;
    }
    public void setCustomerId(int customerId){
        this.customerId = customerId;
    }
    public int getEmployeeId(){
        return employeeId;
    }
    public void setEmployeeId(int employeeId){
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "RegRent: " +
                "id = " + id +
                ", drivenPickupKm = " + drivenPickupKm +
                ", pickupDate = " + pickupDate +
                ", drivenReturnKm = " + drivenReturnKm +
                ", returnDate = " + returnDate +
                ", conditionReport = " + conditionReport +
                ", carRegNumber = " + carRegNumber +
                ", customerId = " + customerId +
                ", employeeId = " + employeeId;
    }
}
