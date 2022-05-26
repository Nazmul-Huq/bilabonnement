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
        return "register-pickup-car.php";
    }

    @PostMapping("/rent/add-pickup-car")
    public String addPickupCar(
            @RequestParam int id,
            @RequestParam int drivenPickupKm,
            @RequestParam Date pickupDate,
            @RequestParam String conditionReport,
            @RequestParam int carRegNumber,
            @RequestParam int customerId,
            @RequestParam int employeeId
            ){
      return "redirect:/rent/register-pickup-car";
    }

    @GetMapping("/rent/register-returned-car")
    public String registerReturnCar(Model model){

        //List<ConditionReport> conditionReportForReturned = registerRentService.showingConditionReport();
        //model.addAttribute("conditionReportForReturned", conditionReportForReturned);
        return "/rent/register-returned-car";
    }

    @PostMapping("/rent/add-returned-car")
    public String addReturnCar(
            @RequestParam int id,
            @RequestParam int drivenReturnKm,
            @RequestParam Date returnDate,
            @RequestParam String conditionReport,
            @RequestParam int carRegNumber,
            @RequestParam int customerId,
            @RequestParam int employeeId
    ) {
        return "redirect:/rent/register-returned-car";
    }
}
