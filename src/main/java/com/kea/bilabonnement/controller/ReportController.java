package com.kea.bilabonnement.controller;

import com.kea.bilabonnement.model.DamageReport;
import com.kea.bilabonnement.service.ReportService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReportController {

    ReportService reportService = new ReportService();
/*
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }
 */

    //Damage Reports
    //---------------------------------------------------------------------------------------------------
    @GetMapping("/report/make-damage-report")
    public String showMakeDamageReport() {
        return "/report/make-damage-report";
    }

    @PostMapping("/report/add-damage-report")
    public String addDamageReport(

            @RequestParam String damageDescription,
            // TODO: 13-05-2022 make number of damage
            @RequestParam int damageLevel,
            @RequestParam int employeeId,
            @RequestParam int carRegNumber
            ) {
        reportService.makeDamageReport(damageDescription,damageLevel, employeeId, carRegNumber);
        return "redirect:/report/make-damage-report";
    }




    //Condition Reports
    //---------------------------------------------------------------------------------------------------

    @GetMapping("/report/make-condition-report")
    public String makeConditionReport() {
        return "/report/make-condition-report";
    }

    @PostMapping("/report/add-condition-report")
    public String addConditionReport(
            @RequestParam int conditionDate,
            @RequestParam String conditionDescription,
            @RequestParam int conditionLevel,
            @RequestParam int conditionEmployeeId,
            @RequestParam int conditionCarRegNumber
    ) {
    reportService.makeConditionReport(conditionDate,conditionDescription,conditionLevel,conditionEmployeeId,conditionCarRegNumber);
        return "redirect:/report/make-condition-report";
    }

    //Registration Reports
    //---------------------------------------------------------------------------------------------------

    @GetMapping("/report/make-registration-report")
    public String makeRegistrationReport() {
        return "/report/make-registration-report";
    }

    @PostMapping("/report/add-registration-report")
    public String addRegistrationReport(
            @RequestParam int regDate,
            @RequestParam int regEmployeeId,
            @RequestParam int regCarRegNumber
    ) {
        reportService.makeRegistrationReport(regDate,regEmployeeId,regCarRegNumber);
        return "redirect:/report/make-registration-report";
    }
}
