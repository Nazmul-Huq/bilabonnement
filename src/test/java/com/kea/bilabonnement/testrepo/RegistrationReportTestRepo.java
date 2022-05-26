package com.kea.bilabonnement.testrepo;

import com.kea.bilabonnement.model.RegReport;
import com.kea.bilabonnement.repo.BilabonnementCRUD;

import java.util.List;

public class RegistrationReportTestRepo implements BilabonnementCRUD<RegReport> {
    @Override
    public boolean addEntity(RegReport entity) {
        return false;
    }

    @Override
    public RegReport getSingleEntityById(int id) {
        return null;
    }

    @Override
    public List<RegReport> getAllEntities() {
        return null;
    }

    @Override
    public List<RegReport> getAllEntitiesById(int id) {
        return null;
    }

    @Override
    public boolean updateEntity(RegReport entity) {
        return false;
    }

    @Override
    public boolean deleteEntityById(int id) {
        return false;
    }
}
