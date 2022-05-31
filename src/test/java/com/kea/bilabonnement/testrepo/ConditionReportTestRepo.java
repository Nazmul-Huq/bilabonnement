//Author: Mo

package com.kea.bilabonnement.testrepo;

import com.kea.bilabonnement.model.ConditionReport;
import com.kea.bilabonnement.repo.BilabonnementCRUD;

import java.util.List;

public class ConditionReportTestRepo implements BilabonnementCRUD<ConditionReport> {
    @Override
    public boolean addEntity(ConditionReport entity) {
        return false;
    }

    @Override
    public ConditionReport getSingleEntityById(int id) {
        ConditionReport singleConditionReport = new ConditionReport(1,12032022,"test",1,1,33333);

        return singleConditionReport;
    }

    @Override
    public List<ConditionReport> getAllEntities() {
        return null;
    }

    @Override
    public List<ConditionReport> getAllEntitiesById(int id) {
        return null;
    }

    @Override
    public boolean updateEntity(ConditionReport entity) {
        return false;
    }

    @Override
    public boolean deleteEntityById(int id) {
        return false;
    }
}
