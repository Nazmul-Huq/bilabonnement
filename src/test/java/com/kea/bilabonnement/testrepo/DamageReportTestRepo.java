//Author: Mo

package com.kea.bilabonnement.testrepo;

import com.kea.bilabonnement.model.DamageReport;
import com.kea.bilabonnement.repo.BilabonnementCRUD;

import java.util.ArrayList;
import java.util.List;

public class DamageReportTestRepo implements BilabonnementCRUD<DamageReport> {


    @Override
    public boolean addEntity(DamageReport entity) {
        return false;
    }

    @Override
    public DamageReport getSingleEntityById(int id) {
        DamageReport singleDamageReport = new DamageReport(1,"test",1,5,1,11111);

        return singleDamageReport;
    }

    @Override
    public List<DamageReport> getAllEntities() {
        return null;
    }

    @Override
    public List<DamageReport> getAllEntitiesById(int id) {
        return null;
    }

    @Override
    public boolean updateEntity(DamageReport entity) {
        return false;
    }

    @Override
    public boolean deleteEntityById(int id) {
        return false;
    }
}
