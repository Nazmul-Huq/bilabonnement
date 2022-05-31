package com.kea.bilabonnement.service;

import com.kea.bilabonnement.model.RentingAgreement;
import com.kea.bilabonnement.repo.PaymentRepo;

import java.util.List;

public class PaymentService {

    PaymentRepo paymentRepo = new PaymentRepo();

    public List<RentingAgreement>getPaymentList(){
        return paymentRepo.getOverviewOfPayments();
    }

    public List<RentingAgreement>getTotalPaymentList(){
        return paymentRepo.getTotalPayment();
    }
}
