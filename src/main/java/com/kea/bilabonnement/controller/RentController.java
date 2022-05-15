package com.kea.bilabonnement.controller;

import com.kea.bilabonnement.service.RentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RentController {
    RentService rentService = new RentService();

    @GetMapping("/rent/make-renting-agreement")
    public String makeAgreement(){
        return "/rent/make-renting-agreement";
    }
    @PostMapping("/rent/add-renting-agreement")
    public String addRentingAgreement(@RequestParam int agreementNumber, @RequestParam int price, @RequestParam String description, @RequestParam int customerId, @RequestParam int carRegNumber, @RequestParam int employeeId){

        rentService.makeRentingAgreement(agreementNumber, price, description, customerId, carRegNumber, employeeId);
        return "redirect:/rent/make-renting-agreement";
    }

    @GetMapping("/rent/finish-renting-periode")
    public String finishAgreement(){
        return null;
    }

}
