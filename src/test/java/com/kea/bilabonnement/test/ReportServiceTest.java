//Author: Mo

package com.kea.bilabonnement.test;

import com.kea.bilabonnement.model.ConditionReport;
import com.kea.bilabonnement.model.DamageReport;
import com.kea.bilabonnement.model.RegReport;
import com.kea.bilabonnement.repo.BilabonnementCRUD;
import com.kea.bilabonnement.repo.DamageReportRepo;
import com.kea.bilabonnement.service.ReportService;
import com.kea.bilabonnement.testrepo.ConditionReportTestRepo;
import com.kea.bilabonnement.testrepo.DamageReportTestRepo;
import com.kea.bilabonnement.testrepo.RegistrationReportTestRepo;
import com.kea.bilabonnement.utility.DatabaseConnectionHandler;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.Assign;

import static org.junit.jupiter.api.Assertions.*;

class ReportServiceTest {


    @Test
    void getSingleConditionEntityById() {
        //Arrange
        BilabonnementCRUD<DamageReport> damageReportTestRepo = new DamageReportTestRepo();
        BilabonnementCRUD<ConditionReport> conditionReportTestRepo = new ConditionReportTestRepo();
        BilabonnementCRUD<RegReport> registrationReportTestRepo = new RegistrationReportTestRepo();

        ReportService reportService = new ReportService(damageReportTestRepo,conditionReportTestRepo,registrationReportTestRepo);
        int idnumber = 1;


        //Assign
        ConditionReport singleConditionReport = (ConditionReport) reportService.getSingleConditionById(idnumber);

        //Assert
        assertEquals(singleConditionReport.getConditionNumber(),idnumber);

    }


    @Test
    void getSingleDamageEntityById() {
        //Arrange
        BilabonnementCRUD<DamageReport> damageReportTestRepo = new DamageReportTestRepo();
        BilabonnementCRUD<ConditionReport> conditionReportTestRepo = new ConditionReportTestRepo();
        BilabonnementCRUD<RegReport> registrationReportTestRepo = new RegistrationReportTestRepo();

        ReportService reportService = new ReportService(damageReportTestRepo,conditionReportTestRepo,registrationReportTestRepo);
        int idnumber = 1;

        //Assign
        DamageReport singleReport = (DamageReport) reportService.getSingleDamageReportById(idnumber);

        //Assert
        assertEquals(singleReport.getNumber(),idnumber);


    }


    @Test
    void getSingleRegistrationEntityById() {
        //Arrange
        BilabonnementCRUD<DamageReport> damageReportTestRepo = new DamageReportTestRepo();
        BilabonnementCRUD<ConditionReport> conditionReportTestRepo = new ConditionReportTestRepo();
        BilabonnementCRUD<RegReport> registrationReportTestRepo = new RegistrationReportTestRepo();

        ReportService reportService = new ReportService(damageReportTestRepo,conditionReportTestRepo,registrationReportTestRepo);
        int idnumber = 1;


        //Assign
        RegReport singleRegistrationReport = (RegReport) reportService.getSingleRegistrationReportById(idnumber);
        //Assert
        assertEquals(singleRegistrationReport.getRegReportNumber(),idnumber);

    }




}