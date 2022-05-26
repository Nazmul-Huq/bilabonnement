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
    void makeDamageReport() {
        //Arrange
        BilabonnementCRUD<DamageReport> damageReportTestRepo = new DamageReportTestRepo();
        BilabonnementCRUD<ConditionReport> conditionReportTestRepo = new ConditionReportTestRepo();
        BilabonnementCRUD<RegReport> registrationReportTestRepo = new RegistrationReportTestRepo();

        ReportService reportService = new ReportService(damageReportTestRepo,conditionReportTestRepo,registrationReportTestRepo);

        //Assign

        //Assert

    }


    @Test
    void getSingleEntityById() {
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


}