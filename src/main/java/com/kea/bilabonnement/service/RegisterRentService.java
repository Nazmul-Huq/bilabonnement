package com.kea.bilabonnement.service;

import com.kea.bilabonnement.model.ConditionReport;
import com.kea.bilabonnement.model.RegisterRent;
import com.kea.bilabonnement.repo.RegisterRentRepo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class RegisterRentService {

    RegisterRentRepo registerRentRepo = new RegisterRentRepo();

    public void registerReturnedCars(int carRegNumber, double drivenReturnKm, String conditionReport, Date returnDate, int employeeId){
        RegisterRent registerRent = new RegisterRent(carRegNumber, drivenReturnKm, conditionReport, returnDate, employeeId);
        registerRentRepo.addEntity(registerRent);
    }

    public void registerPickupCar(String location, int carRegNumber, double drivenPickupKm, String conditionReport, Date returnDate, int employeeId){
        RegisterRent registerRent = new RegisterRent(location, carRegNumber, drivenPickupKm, conditionReport, returnDate, employeeId);
        registerRentRepo.addEntity(registerRent);
    }
}
