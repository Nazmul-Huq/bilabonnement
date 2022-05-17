package com.kea.bilabonnement.controller;

import com.kea.bilabonnement.service.RentService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RentController {
    RentService rentService = new RentService();

    @InitBinder
    public void initBinderDate(WebDataBinder binder){
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
            @RequestParam int employeeId,
            @RequestParam boolean rentingStatus){

        rentService.makeRentingAgreement(price, description, customerId, carRegNumber, employeeId, rentingStatus);
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
            @RequestParam boolean rentingStatus,
            @RequestParam Date endingDate){
        rentService.endRentingAgreement(agreementNumber, carRegNumber, customerId, description, employeeId, rentingStatus, endingDate);
        return "redirect:/rent/finish-renting-periode";
    }
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public void handleMissingParams(MissingServletRequestParameterException ex) {
        String name = ex.getParameterName();
        String location = ex.getLocalizedMessage();
        System.out.println(name + " parameter is missing " + " at " + location);
    }

}
