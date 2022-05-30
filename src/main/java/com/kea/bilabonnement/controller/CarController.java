package com.kea.bilabonnement.controller;

//Forfatter: Sara

import com.kea.bilabonnement.model.Car;
import com.kea.bilabonnement.repo.BilabonnementCRUD;
import com.kea.bilabonnement.repo.CarRepo;
import com.kea.bilabonnement.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
public class CarController {

    BilabonnementCRUD<Car> bil = new CarRepo();

    CarService bilService = new CarService(bil);




    @GetMapping("/car/register-new-car")
    public String registerCar(){
        return "car/register-new-car";
    }

    @GetMapping("/car/see-car-current-status")
    public String currentStatusCar(){
        return "/car/see-car-current-status";
    }

    @PostMapping("/car/add-register-new-car")
    public String registerCarInput(
            @RequestParam int registreringsnummer,
            @RequestParam String bilmærke,
            @RequestParam String bilmodel,
            @RequestParam String bilfarve,
            @RequestParam String tilbehør,
            @RequestParam int chassis,
            @RequestParam int kørtekm,
            @RequestParam int tax,
            @RequestParam int co2,
            @RequestParam int fastsatpris,
            @RequestParam String brændstof,
            @RequestParam Date dato) {

        bilService.makeCar(registreringsnummer, bilmærke,bilmodel, bilfarve, tilbehør, chassis, kørtekm, tax, co2, fastsatpris, brændstof, dato);

        return "redirect:/car/register-new-car";
    }

    @GetMapping("/car/delete-registered-car")
    public String deleteRegisteredCar() {
        return "/car/delete-registered-car";
    }

    @PostMapping("/car/delete-registered-cars")
    public String deleteCar(@RequestParam int regNumber){

        bilService.deleteCarById(regNumber);

        return "/car/delete-registered-car";
    }

}
