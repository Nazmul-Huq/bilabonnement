package com.kea.bilabonnement.service;

import com.kea.bilabonnement.model.RentingAgreement;
import com.kea.bilabonnement.repo.RentRepo;

public class RentService {

    RentRepo rentRepo = new RentRepo();

    public void makeRentingAgreement(int agreementNumber, int price, String description, int customerId, int carRegNumber, int employeeId){
        RentingAgreement rentingAgreement = new RentingAgreement(agreementNumber, price, description, customerId, carRegNumber, employeeId);
        rentRepo.addEntity(rentingAgreement);
    }
}
