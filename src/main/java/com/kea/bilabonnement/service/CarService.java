package com.kea.bilabonnement.service;

//Forfatter: Sara

import com.kea.bilabonnement.model.Car;
import com.kea.bilabonnement.repo.BilabonnementCRUD;

import java.sql.Date;
import java.util.List;

public class CarService {

    BilabonnementCRUD<Car>carRepo;

    public CarService(BilabonnementCRUD<Car>carRepo) {
        this.carRepo = carRepo;
    }

    //add Entity - registere ny bil i systemet og gem i database
    public void makeCar(int regNumber, String carBrand, String carModel, String carColor, String accessories, int chasisLevel, int drivenKM, int tax, int co2Emission, int stelPrice, String fuelType, Date dateOfCar) {
        Car registerCar = new Car(regNumber, carBrand, carModel, carColor, accessories, chasisLevel, drivenKM, tax, co2Emission, stelPrice, fuelType, dateOfCar);

        carRepo.addEntity(registerCar);
    }

    //Delete Entity - slet bil i systemet
    public void deleteCarById(int id) {
        carRepo.deleteEntityById(id);
    }

    //Update system - opdatere ændringer i systemet
    public void updateCar(int regNumber, String carBrand, String carModel, String carColor, String accessories, int chasisLevel, int drivenKM, int tax, int co2Emission, int stelPrice, String fuelType, Date dateOfCar) {
        Car updateCarChanges = new Car(regNumber, carBrand, carModel, carColor, accessories, chasisLevel, drivenKM, tax, co2Emission, stelPrice, fuelType, dateOfCar);

        carRepo.updateEntity(updateCarChanges);
    }

    //get single entity by id - viser en enhed fra 'cars' i systemet fra dens ID
    public Car getCarByID(int id) {
        return carRepo.getSingleEntityById(id);
    }

    //Get all tables - viser alle enheder inde under 'cars' i systemet
    public List<Car> getAllCars() {
        return carRepo.getAllEntities();
    }



}
