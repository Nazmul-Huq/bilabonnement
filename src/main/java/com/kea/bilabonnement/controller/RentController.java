package com.kea.bilabonnement.controller;

import com.kea.bilabonnement.model.RentingAgreement;
import com.kea.bilabonnement.repo.BilabonnementCRUD;
import com.kea.bilabonnement.repo.RentRepo;
import com.kea.bilabonnement.service.RentService;
import com.kea.bilabonnement.service.ReportService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

@Controller
public class RentController {

    BilabonnementCRUD<RentingAgreement> rentRepo = new RentRepo();
    RentService rentService = new RentService(rentRepo);

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
            @RequestParam String type,
            @RequestParam int customerId,
            @RequestParam int carRegNumber,
            @RequestParam int employeeId,
            @RequestParam boolean rentingStatus,
            @RequestParam Date agreementDate){

        rentService.makeRentingAgreement(price, description, type, customerId, carRegNumber, employeeId, rentingStatus, agreementDate);
        return "redirect:/rent/make-renting-agreement";
    }

    @GetMapping("/rent/finish-renting-periode")
    public String finishAgreement(){
        return "/rent/finish-renting-periode";
    }

    @PostMapping("/rent/add-finish-renting-periode")
    public String finishRentingAgreement(
            @RequestParam int agreementNumber,
            @RequestParam int carRegNumber,
            @RequestParam int customerId,
            @RequestParam String description,
            @RequestParam int employeeId,
            @RequestParam boolean rentingStatus,
            @RequestParam Date endingDate){
        rentService.endRentingAgreement(agreementNumber, carRegNumber, customerId, description, employeeId, endingDate, rentingStatus);
        return "redirect:/rent/finish-renting-periode";
    }

    @GetMapping("/rent/show-renting-agreement.html")
    public String showRentingAgreement(Model model){
        List<RentingAgreement> agreementList = rentService.getAgreementList();
        model.addAttribute("showAgreements", agreementList);
        return "/rent/show-renting-agreement";
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public void handleMissingParams(MissingServletRequestParameterException ex) {
        String name = ex.getParameterName();
        String location = ex.getLocalizedMessage();
        System.out.println(name + " parameter is missing " + " at " + location);
    }
}
