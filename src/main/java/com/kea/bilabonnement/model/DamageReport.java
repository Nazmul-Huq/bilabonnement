package com.kea.bilabonnement.model;

public class DamageReport {

    //Attributes
    private int damageNumber;
    private String damageDescription;
    private int noOfDamage;
    private int damageLevel;
    private int employeeId;
    private int carRegNr;

    //Constructor
    public DamageReport(int damageNumber, String damageDescription, int noOfDamage, int damageLevel, int employeeId, int carRegNr) {
        this.damageNumber = damageNumber;
        this.damageDescription = damageDescription;
        this.noOfDamage = noOfDamage;
        this.damageLevel = damageLevel;
        this.employeeId = employeeId;
        this.carRegNr = carRegNr;
    }

    //Getters and Setters
    public int getNumber() {
        return damageNumber;
    }

    public String getDamageDescription() {
        return damageDescription;
    }

    public int getNoOfDamage() {
        return noOfDamage;
    }

    public int getDamageLevel() {
        return damageLevel;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getCarRegNr() {
        return carRegNr;
    }


    //toString
    @Override
    public String toString() {
        return "DamageReport{" +
                "Damage Number: " + damageNumber +
                ", Damage Description: '" + damageDescription + '\'' +
                ", Number Of Damages: " + noOfDamage +
                ", Damage Level: " + damageLevel +
                ", Employee Id: " + employeeId +
                ", Car Reg Nr: " + carRegNr +
                '}';
    }
}
