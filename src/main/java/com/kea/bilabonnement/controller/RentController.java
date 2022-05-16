package com.kea.bilabonnement.controller;

import com.kea.bilabonnement.service.RentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class RentController {
    RentService rentService = new RentService();

    @GetMapping("/rent/make-renting-agreement")
    public String makeAgreement(){
        return "/rent/make-renting-agreement";
    }

    @PostMapping("/rent/add-renting-agreement")
    public String addRentingAgreement(
            @RequestParam int price,
            @RequestParam String description,
            @RequestParam int customerId,
            @RequestParam int carRegNumber,
            @RequestParam int employeeId){

        rentService.makeRentingAgreement(price, description, customerId, carRegNumber, employeeId);
        return "redirect:/rent/make-renting-agreement";
    }

    @GetMapping("/rent/finish-renting-periode")
    public String finishAgreement(){
        return "/rent/finish-renting-periode";
    }

    @PostMapping("/rent/finish-renting-agreement")
    public String finishRentingAgreement(
            @RequestParam int carRegNumber,
            @RequestParam int customerId,
            @RequestParam String description,
            @RequestParam int employeeId,
            @RequestParam Date endingDate){
        rentService.endRentingAgreement(carRegNumber, customerId, description, employeeId, endingDate);
        return "redirect:/rent/finish-renting-periode";
    }

}
