package com.kea.bilabonnement.testrepo;

import com.kea.bilabonnement.model.RentingAgreement;
import com.kea.bilabonnement.repo.BilabonnementCRUD;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class RentTestRepo implements BilabonnementCRUD<RentingAgreement> {


    DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");


    @Override
    public boolean addEntity(RentingAgreement entity) {
        return false;
    }

    @Override
    public RentingAgreement getSingleEntityById(int id) {return null;
    }



    @Override
    public List<RentingAgreement> getAllEntities() {
        RentingAgreement singleAgreement = new RentingAgreement(29000, "test", "test2", 1, 124454, 1, true);
        return getAllEntities();
    }

    @Override
    public List<RentingAgreement> getAllEntitiesById(int id) {
        return null;
    }

    @Override
    public boolean updateEntity(RentingAgreement entity) {
        return false;
    }

    @Override
    public boolean deleteEntityById(int id) {
        return false;
    }
}
