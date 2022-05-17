package com.kea.bilabonnement.service;

import com.kea.bilabonnement.model.ConditionReport;
import com.kea.bilabonnement.model.DamageReport;
import com.kea.bilabonnement.model.RegReport;
import com.kea.bilabonnement.repo.ConditionReportRepo;
import com.kea.bilabonnement.repo.DamageReportRepo;
import com.kea.bilabonnement.repo.RegistrationReportRepo;

import java.util.List;


public class ReportService {


    DamageReportRepo damageReportRepo = new DamageReportRepo();
    ConditionReportRepo conditionReportRepo = new ConditionReportRepo();
    RegistrationReportRepo registrationReportRepo = new RegistrationReportRepo();



    //Makes a table
    //------------------------------------------------------------------------------------------------------------------

    //Damage
    public void makeDamageReport(String damageDescription, int noOfDamage, int damageLevel, int employeeId, int carRagNumber) {
        DamageReport damageReport = new DamageReport(damageDescription,noOfDamage,damageLevel,employeeId,carRagNumber);
        damageReportRepo.addEntity(damageReport);
    }

    //Condition
    public void makeConditionReport(int conditionDate, String conditionDescription, int conditionLevel, int conditionEmployeeId, int conditionCarRegNumber) {
        ConditionReport conditionReport = new ConditionReport(conditionDate,conditionDescription,conditionLevel,conditionEmployeeId,conditionCarRegNumber);
        conditionReportRepo.addEntity(conditionReport);
    }

    //Registration
    public void makeRegistrationReport(int regDate,int regEmployeeId,int regCarRegNr) {
        RegReport regReport = new RegReport(regDate, regEmployeeId, regCarRegNr);
        registrationReportRepo.addEntity(regReport);
    }


    //Gets single entity by Ids
    //------------------------------------------------------------------------------------------------------------------

    //Damage
    public void getSingleDamageEntityById() {

    }

    //Condition
    public void getSingleConditionEntityById() {

    }

    //Registration
    public void getSingleRegistrationById() {

    }


    //Gets reports by Ids
    //------------------------------------------------------------------------------------------------------------------

    //Damage
    public void getSingleDamageReportById(int number) {

        damageReportRepo.getAllEntitiesById(number);
    }

    //Condition
    public void getSingleConditionById(int number) {

        conditionReportRepo.getAllEntitiesById(number);
    }

    //Registration
    public void getSingleRegistrationReport(int number) {

        registrationReportRepo.getAllEntitiesById(number);
    }

    //Gets All Tables
    //------------------------------------------------------------------------------------------------------------------

    //Damage
    public List<DamageReport> getAllDamageReports() {
        return damageReportRepo.getAllEntities();
    }

    //Condition
    public List<ConditionReport> getAllConditionReports() {
        return conditionReportRepo.getAllEntities();
    }

    //Registration
    public List<RegReport> getAllRegistrationReports() {
        return registrationReportRepo.getAllEntities();
    }

    //Updates Tables
    //------------------------------------------------------------------------------------------------------------------

    //Damage
    public void updateDamageReport(String damageDescription, int damageLevel, int employeeId, int carRagNumber) {
        DamageReport damageReport = new DamageReport(damageDescription,1, damageLevel, employeeId, carRagNumber);
        damageReportRepo.updateEntity(damageReport);
    }

    //Condition
    public void updateConditionReport(int conditionDate, String conditionDescription, int conditionLevel, int conditionEmployeeId, int conditionCarRegNumber) {
        ConditionReport conditionReport = new ConditionReport(conditionDate, conditionDescription, conditionLevel, conditionEmployeeId, conditionCarRegNumber);
        conditionReportRepo.updateEntity(conditionReport);
    }

    //Registration
    public void updateRegistrationReport(int regDate,int regEmployeeId,int regCarRegNr) {
        RegReport regReport = new RegReport(regDate, regEmployeeId, regCarRegNr);
        registrationReportRepo.updateEntity(regReport);
    }

    //Deletes tables by ids
    //------------------------------------------------------------------------------------------------------------------

    //Damage
    public Object deleteDamageReportById(int number) {
        damageReportRepo.deleteEntityById(number);
        return number;
    }

    //Condition
    public void deleteConditionReportById(int number) {
        conditionReportRepo.deleteEntityById(number);
    }

    //Registration
    public void deleteRegistrationReportById(int number) {
        registrationReportRepo.deleteEntityById(number);
    }
}
