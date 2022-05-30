package com.kea.bilabonnement.test;

import com.kea.bilabonnement.model.ConditionReport;
import com.kea.bilabonnement.model.DamageReport;
import com.kea.bilabonnement.model.Lease;
import com.kea.bilabonnement.model.RegReport;
import com.kea.bilabonnement.repo.BilabonnementCRUD;
import com.kea.bilabonnement.service.LeaseService;
import com.kea.bilabonnement.service.ReportService;
import com.kea.bilabonnement.testrepo.ConditionReportTestRepo;
import com.kea.bilabonnement.testrepo.DamageReportTestRepo;
import com.kea.bilabonnement.testrepo.LeaseTestRepo;
import com.kea.bilabonnement.testrepo.RegistrationReportTestRepo;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Author Nazmul
 */

public class LeaseServiceTest {


    @Test
    void finishLeaseTest() {
        //Arrange
        BilabonnementCRUD<Lease> leaseRepo = new LeaseTestRepo();
        LeaseService leaseService = new LeaseService(leaseRepo);
        int id = 1;
        Date date = new Date(2022-05-30);
        int carRegNumber = 11111;


        //Assign
       boolean isLeaseFinished = leaseService.finishLease(id, date, carRegNumber);

        //Assert
        assertEquals(isLeaseFinished, true);

    }
}
