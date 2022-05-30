package com.kea.bilabonnement.testrepo;

import com.kea.bilabonnement.model.Lease;
import com.kea.bilabonnement.repo.BilabonnementCRUD;

import java.util.List;

/**
 * Author Nazmul
 */

public class LeaseTestRepo implements BilabonnementCRUD<Lease> {
    @Override
    public boolean addEntity(Lease entity) {
        return false;
    }

    @Override
    public Lease getSingleEntityById(int id) {
        return null;
    }

    @Override
    public List<Lease> getAllEntities() {
        return null;
    }

    @Override
    public List<Lease> getAllEntitiesById(int id) {
        return null;
    }

    @Override
    public boolean updateEntity(Lease entity) {
        if (entity.getId() == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteEntityById(int id) {
        return false;
    }
}
