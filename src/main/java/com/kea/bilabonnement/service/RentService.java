package com.kea.bilabonnement.service;

import com.kea.bilabonnement.model.RentingAgreement;
import com.kea.bilabonnement.repo.BilabonnementCRUD;
import com.kea.bilabonnement.repo.RentRepo;

import java.util.Date;
import java.util.List;

/**Written by Søs**/
public class RentService {

   BilabonnementCRUD<RentingAgreement> rentRepo;

    public RentService(BilabonnementCRUD<RentingAgreement>rentRepo){
        this.rentRepo = rentRepo;
    }

    public void makeRentingAgreement(int price, String description, String type, int customerId, int carRegNumber, int employeeId, boolean rentingStatus, Date agreementDate){

        RentingAgreement rentingAgreement = new RentingAgreement(price, description, type, customerId, carRegNumber, employeeId, rentingStatus, (java.sql.Date) agreementDate);
        rentRepo.addEntity(rentingAgreement);

    }
    public boolean endRentingAgreement(int agreementNumber, int carRegNumber, int customerId, String description, int employeeId, Date endingDate, boolean rentingStatus){
        RentingAgreement rentingAgreement = new RentingAgreement(agreementNumber, carRegNumber, customerId, description, employeeId, (java.sql.Date) endingDate, rentingStatus);
        return rentRepo.updateEntity(rentingAgreement);
    }

    public List<RentingAgreement> getAgreementList() {
        return rentRepo.getAllEntities();
    }
}
