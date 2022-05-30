package com.kea.bilabonnement.controller;

//Forfatter: Sara

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarController {

    @GetMapping("/car/register-new-car")
    public String registerCar(){
        return "car/register-new-car";
    }

    @GetMapping("/car/see-car-current-status")
    public String currentStatusCar(){
        return "/car/see-car-current-status";
    }
}
