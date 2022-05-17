package com.kea.bilabonnement.model;

import java.util.Date;

public class RegRent {

    private int id;
    private double drivenPickupKm;
    private Date pickupDate;
    private double drivenReturnKm;
    private Date returnDate;
    private int conditionReport;
    private int carRegNumber;
    private int customerId;
    private int employeeId;

    public RegRent() {
    }

    public RegRent(int id, double drivenPickupKm, Date pickupDate, double drivenReturnKm, Date returnDate, int conditionReport, int carRegNumber, int customerId, int employeeId) {
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

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
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
    public int getConditionReport(){
        return conditionReport;
    }
    public void setConditionReport(int conditionReport){
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
