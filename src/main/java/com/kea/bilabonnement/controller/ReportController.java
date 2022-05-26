package com.kea.bilabonnement.controller;

import com.kea.bilabonnement.model.ConditionReport;
import com.kea.bilabonnement.model.DamageReport;
import com.kea.bilabonnement.model.RegReport;
import com.kea.bilabonnement.repo.BilabonnementCRUD;
import com.kea.bilabonnement.repo.ConditionReportRepo;
import com.kea.bilabonnement.repo.DamageReportRepo;
import com.kea.bilabonnement.repo.RegistrationReportRepo;
import com.kea.bilabonnement.service.ReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ReportController {
    BilabonnementCRUD<DamageReport> damageReportRepo = new DamageReportRepo();
    BilabonnementCRUD<ConditionReport> conditionReportRepo = new ConditionReportRepo();
    BilabonnementCRUD<RegReport>registrationReportRepo = new RegistrationReportRepo();



    ReportService reportService = new ReportService(damageReportRepo,conditionReportRepo,registrationReportRepo);

/*
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }
 */

    //Damage Reports
    //---------------------------------------------------------------------------------------------------

    //Create
    @GetMapping("/report/make-damage-report")
    public String showMakeDamageReport() {
        return "/report/make-damage-report";
    }

    @PostMapping("/report/add-damage-report")
    public String addDamageReport(

            @RequestParam String damageDescription,
            @RequestParam int noOfDamage,
            @RequestParam int damageLevel,
            @RequestParam int employeeId,
            @RequestParam int carRegNumber
            ) {
        reportService.makeDamageReport(damageDescription,noOfDamage,damageLevel, employeeId, carRegNumber);
        return "redirect:/report/make-damage-report";
    }


    //Read
    @GetMapping("/report/show-damage-report")
    public String showDamageReports(Model model) {
        model.addAttribute("damagereports", reportService.getAllDamageReports());
        return "/report/show-damage-report";
    }

    //Read single Damage Report
    @GetMapping("/report/search-damage-result")
    public String showSingleDamageReport(Model model, int number) {
        System.out.println(reportService.getSingleDamageReportById(number));

        model.addAttribute("damagereport",reportService.getSingleDamageReportById(number));
        return "/report/search-damage-result";
    }


    //Delete
    @GetMapping("/report/delete-damage-report")
    public String deleteDamageReportById() {
        return "/report/delete-damage-report";
    }

    @PostMapping("/report/delete-report")
    public String deleteDamageReport(@RequestParam int number){
        reportService.deleteDamageReportById(number);
        return "/report/delete-damage-report";
    }

    //Search
    @GetMapping("/report/search-damage-report")
    public String searchDamageReports() {
        return "/report/search-damage-report";
    }

    @PostMapping("/report/search-report")
    public String searchDamageReportById(@RequestParam int number) {
        reportService.getSingleDamageReportById(number);
        return "/report/search-damage-result";
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


    @GetMapping("/report/show-condition-report")
    public String showConditionReports(Model model) {
        model.addAttribute("conditionreports", reportService.getAllConditionReports());
        return "/report/show-condition-report";
    }


    //Delete
    @GetMapping("/report/delete-condition-report")
    public String deleteConditionReportById() {
        return "/report/delete-condition-report";
    }

    @PostMapping("/report/delete-condition-report")
    public String deleteConditionReport(@RequestParam int number){
        reportService.deleteConditionReportById(number);
        return "/report/delete-condition-report";
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

    @GetMapping("/report/show-registration-report")
    public String showRegistrationReports(Model model) {
        model.addAttribute("registrationreports", reportService.getAllRegistrationReports());
        return "/report/show-registration-report";
    }

    //Delete
    @GetMapping("/report/delete-registration-report")
    public String deleteRegistrationReportById() {
        return "/report/delete-registration-report";
    }

    @PostMapping("/report/delete-reg-report")
    public String deleteRegistrationReport(@RequestParam int number){
        reportService.deleteRegistrationReportById(number);
        return "/report/delete-registration-report";
    }
}
