package com.kea.bilabonnement.service;

import com.kea.bilabonnement.model.RentingAgreement;
import com.kea.bilabonnement.repo.RentRepo;

import java.util.Date;
import java.util.List;

public class RentService {

    RentRepo rentRepo = new RentRepo();

    public void makeRentingAgreement(int price, String description, int customerId, int carRegNumber, int employeeId, boolean rentingStatus, Date agreementDate){

        RentingAgreement rentingAgreement = new RentingAgreement(price, description, customerId, carRegNumber, employeeId, rentingStatus, (java.sql.Date) agreementDate);
        rentRepo.addEntity(rentingAgreement);

    }
    public void endRentingAgreement(int agreementNumber, int carRegNumber, int customerId, String description, int employee, boolean rentingStatus, Date endingDate){
        RentingAgreement rentingAgreement = new RentingAgreement(agreementNumber, carRegNumber, customerId, description, employee, rentingStatus, (java.sql.Date) endingDate);
        rentRepo.updateEntity(rentingAgreement);
    }

    public List<RentingAgreement> getAgreementList() {

        return null;
    }
}
