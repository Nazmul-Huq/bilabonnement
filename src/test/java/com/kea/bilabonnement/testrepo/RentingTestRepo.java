package com.kea.bilabonnement.testrepo;

import com.kea.bilabonnement.model.RentingAgreement;
import com.kea.bilabonnement.repo.BilabonnementCRUD;

import java.util.List;

/** Written by Søs **/
public class RentingTestRepo implements BilabonnementCRUD<RentingAgreement>
{
    @Override
    public boolean addEntity(RentingAgreement entity) {
        return false;
    }

    @Override
    public RentingAgreement getSingleEntityById(int id) {
        return null;
    }

    @Override
    public List<RentingAgreement> getAllEntities() {
        return null;
    }

    @Override
    public List<RentingAgreement> getAllEntitiesById(int id) {
        return null;
    }

    @Override
    public boolean updateEntity(RentingAgreement entity) {

        if (entity.getCarRegNumber()==11111){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteEntityById(int id) {
        return false;
    }
}
