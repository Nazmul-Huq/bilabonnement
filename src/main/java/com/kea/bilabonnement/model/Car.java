package com.kea.bilabonnement.model;

import java.sql.Date;

public class Car {

    //Attributes
    private int regNumber;
    private String carBrand;
    private String carModel;
    private String carColor;
    private String accessories;
    private int chasisNumber;
    private String plateNumber;
    private int drivenKM;
    private int tax;
    private int co2Emission;
    private int stelPrice;
    private String fuelType;
    private Date regDate;



    //Constructor
    public Car(int regNumber, String carBrand, String carModel, String carColor, String accessories, int chasisNumber, String plateNumber, int drivenKM, int tax, int co2Emission, int stelPrice, String fuelType, Date regDate) {
        this.regNumber = regNumber;
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.carColor = carColor;
        this.accessories = accessories;
        this.chasisNumber = chasisNumber;
        this.plateNumber = plateNumber;
        this.drivenKM = drivenKM;
        this.tax = tax;
        this.co2Emission = co2Emission;
        this.stelPrice = stelPrice;
        this.fuelType = fuelType;
        this.regDate = regDate;
    }

    //Getters


    public int getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(int regNumber) {
        this.regNumber = regNumber;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getAccessories() {
        return accessories;
    }

    public void setAccessories(String accessories) {
        this.accessories = accessories;
    }

    public int getChasisNumber() {
        return chasisNumber;
    }

    public void setChasisNumber(int chasisNumber) {
        this.chasisNumber = chasisNumber;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public int getDrivenKM() {
        return drivenKM;
    }

    public void setDrivenKM(int drivenKM) {
        this.drivenKM = drivenKM;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public int getCo2Emission() {
        return co2Emission;
    }

    public void setCo2Emission(int co2Emission) {
        this.co2Emission = co2Emission;
    }

    public int getStelPrice() {
        return stelPrice;
    }

    public void setStelPrice(int stelPrice) {
        this.stelPrice = stelPrice;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    //toString

    @Override
    public String toString() {
        return "Car{" +
                "regNumber=" + regNumber +
                ", carBrand='" + carBrand + '\'' +
                ", carModel='" + carModel + '\'' +
                ", carColor='" + carColor + '\'' +
                ", accessories='" + accessories + '\'' +
                ", chasisNumber=" + chasisNumber +
                ", plateNumber='" + plateNumber + '\'' +
                ", drivenKM=" + drivenKM +
                ", tax=" + tax +
                ", co2Emission=" + co2Emission +
                ", stelPrice=" + stelPrice +
                ", fuelType='" + fuelType + '\'' +
                ", regDate=" + regDate +
                '}';
    }
}
