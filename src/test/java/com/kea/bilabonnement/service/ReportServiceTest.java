package com.kea.bilabonnement.service;

import com.kea.bilabonnement.model.ConditionReport;
import com.kea.bilabonnement.model.DamageReport;
import com.kea.bilabonnement.repo.DamageReportRepo;
import com.kea.bilabonnement.utility.DatabaseConnectionHandler;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class ReportServiceTest {


    @Test
    void makeDamageReport() {
        var damageReport = new DamageReport();
        damageReport.getDamageDescription();
        damageReport.getNoOfDamage();
        damageReport.getDamageLevel();
        damageReport.getEmployeeId();
        damageReport.getCarRegNr();
    }


    @Test
    void getAllDamageReports() {
        DamageReportRepo allDamageReports = new DamageReportRepo();

        allDamageReports.getAllEntities();
    }


}