package com.kea.bilabonnement.controller;

import com.kea.bilabonnement.service.RegisterRentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;


@Controller
public class RegisterRentController {

    RegisterRentService registerRentService = new RegisterRentService();

    @GetMapping("/rent/register-pickup-car")
    public String registerPickupCar(){
        return "/rent/register-pickup-car";
    }

    @PostMapping("/rent/add-pickup-car")
    public String addPickupCar(
            @RequestParam String location,
            @RequestParam int carRegNumber,
            @RequestParam int drivenPickupKm,
            @RequestParam String conditionReport,
            @RequestParam Date pickupDate,
            @RequestParam int employeeId){
        registerRentService.registerPickupCar(location, carRegNumber, drivenPickupKm, conditionReport, pickupDate, employeeId);
      return "redirect:/rent/register-pickup-car";
    }

    @GetMapping("/rent/register-returned-car")
    public String registerReturnCar(){
        return "/rent/register-returned-car";
    }

    @PostMapping("/rent/add-returned-car")
    public String addReturnCar(
            @RequestParam int carRegNumber,
            @RequestParam int drivenReturnKm,
            @RequestParam String conditionReport,
            @RequestParam Date returnDate,
            @RequestParam int employeeId) {
        registerRentService.registerReturnedCars(carRegNumber, drivenReturnKm, conditionReport, returnDate, employeeId);
        return "redirect:/rent/register-returned-car";
    }
}
