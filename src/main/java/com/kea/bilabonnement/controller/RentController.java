package com.kea.bilabonnement.controller;

import com.kea.bilabonnement.service.RentService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RentController {
    RentService rentService = new RentService();

    @InitBinder
    public void initBinder(WebDataBinder binder){
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

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
            @RequestParam int agreementNumber,
            @RequestParam int carRegNumber,
            @RequestParam int customerId,
            @RequestParam String description,
            @RequestParam int employeeId,
            @RequestParam Date endingDate){
        rentService.endRentingAgreement(agreementNumber, carRegNumber, customerId, description, employeeId, endingDate);
        return "redirect:/rent/finish-renting-periode";
    }

}
