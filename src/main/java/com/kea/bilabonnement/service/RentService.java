package com.kea.bilabonnement.service;

import com.kea.bilabonnement.model.RentingAgreement;
import com.kea.bilabonnement.repo.RentRepo;

import java.util.Date;

public class RentService {

    RentRepo rentRepo = new RentRepo();

    public void makeRentingAgreement(int price, String description, int customerId, int carRegNumber, int employeeId){
        RentingAgreement rentingAgreement = new RentingAgreement(price, description, customerId, carRegNumber, employeeId);
        rentRepo.addEntity(rentingAgreement);
        rentRepo.writeToFile();
    }
    public void endRentingAgreement(int agreementNumber, int carRegNumber, int customerId, String description, int employee, Date endingDate){
        RentingAgreement rentingAgreement = new RentingAgreement(agreementNumber, carRegNumber, customerId, description, employee, endingDate);
        rentRepo.deleteEntityById(rentingAgreement.getAgreementNumber());
    }
}
