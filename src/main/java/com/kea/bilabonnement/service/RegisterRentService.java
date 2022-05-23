package com.kea.bilabonnement.service;

import com.kea.bilabonnement.model.ConditionReport;
import com.kea.bilabonnement.repo.RegisterRentRepo;

import java.util.ArrayList;
import java.util.List;

public class RegisterRentService {

    RegisterRentRepo registerRentRepo = new RegisterRentRepo();

    public List<ConditionReport> showingConditionReport(){
        return registerRentRepo.getConditionReport();
    }
}
