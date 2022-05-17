package com.kea.bilabonnement.service;

import com.kea.bilabonnement.model.RentingAgreement;
import com.kea.bilabonnement.repo.RentRepo;

import java.util.Date;

public class RentService {

    RentRepo rentRepo = new RentRepo();

    public void makeRentingAgreement(int price, String description, int customerId, int carRegNumber, int employeeId, boolean rentingStatus){
        RentingAgreement rentingAgreement = new RentingAgreement(price, description, customerId, carRegNumber, employeeId, rentingStatus);
        rentRepo.addEntity(rentingAgreement);

    }
    public void endRentingAgreement(int agreementNumber, int carRegNumber, int customerId, String description, int employee, boolean rentingStatus, Date endingDate){
        RentingAgreement rentingAgreement = new RentingAgreement(agreementNumber, carRegNumber, customerId, description, employee, rentingStatus, endingDate);
        rentRepo.deleteEntityById(rentingAgreement.getAgreementNumber());
    }
}
