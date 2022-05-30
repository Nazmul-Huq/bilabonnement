package com.kea.bilabonnement.model;

//Forfatter: Sara

import java.sql.Date;

public class Car {

    //Attributes
    private int regNumber;
    private String carBrand;
    private String carModel;
    private String carColor;
    private String accessories;
    private int chasisLevel;
    private int drivenKM;
    private int tax;
    private int co2Emission;
    private int stelPrice;
    private String fuelType;
    private Date dateOfCar;


    //Constructor
    public Car(int regNumber, String carBrand, String carModel, String carColor, String accessories, int chasisLevel, int drivenKM, int tax, int co2Emission, int stelPrice, String fuelType, Date dateOfCar) {

        this.regNumber = regNumber;
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.carColor = carColor;
        this.accessories = accessories;
        this.chasisLevel = chasisLevel;
        this.drivenKM = drivenKM;
        this.tax = tax;
        this.co2Emission = co2Emission;
        this.stelPrice = stelPrice;
        this.fuelType = fuelType;
        this.dateOfCar = dateOfCar;

    }

    //Getters
    public int getRegNumber(){
        return regNumber;
    }

    public String getCarBrand(){
        return carBrand;
    }

    public String getCarModel(){
        return carModel;
    }

    public String getCarColor(){
        return carColor;
    }

    public String getAccessories() {
        return accessories;
    }

    public int getChasisLevel() {
        return chasisLevel;
    }

    public int getDrivenKM() {
        return drivenKM;
    }

    public int getTax() {
        return tax;
    }

    public int getCo2Emission() {
        return co2Emission;
    }

    public int getStelPrice() {
        return stelPrice;
    }

    public String getFuelType() {
        return fuelType;
    }

    public Date getDateOfCar() {
        return dateOfCar;
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
                ", chasisLevel=" + chasisLevel +
                ", drivenKM=" + drivenKM +
                ", tax=" + tax +
                ", co2Emission=" + co2Emission +
                ", stelPrice=" + stelPrice +
                ", fuelType='" + fuelType + '\'' +
                ", dateOfCar=" + dateOfCar +
                '}';
    }
}
