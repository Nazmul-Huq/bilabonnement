package com.kea.bilabonnement.service;

import com.kea.bilabonnement.model.RentingAgreement;
import com.kea.bilabonnement.repo.BilabonnementCRUD;
import com.kea.bilabonnement.testrepo.RentingTestRepo;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

/** Written by Søs **/
class RentServiceTest {

    @Test
    void endRentingAgreementTest() {

        //Arrange
        BilabonnementCRUD<RentingAgreement> rentRepo = new RentingTestRepo();
        RentService rentService = new RentService(rentRepo);
        int agreementNumber = 1;
        int carRegNumber = 11111;
        int customerId = 1;
        String description = "Rød";
        int employeeId = 1;
        Date endingDate = new Date(2022-06-07);
        boolean rentingStatus = true;


        //Act
        boolean isAgreementFinish = rentService.endRentingAgreement(agreementNumber, carRegNumber, customerId, description, employeeId, endingDate,rentingStatus);


        //Assert
        assertEquals(isAgreementFinish, true);

    }
}