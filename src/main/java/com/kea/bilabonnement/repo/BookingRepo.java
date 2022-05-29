package com.kea.bilabonnement.repo;

import com.kea.bilabonnement.model.Booking;

import java.util.List;

public class BookingRepo implements BilabonnementCRUD<Booking> {
    @Override
    public boolean addEntity(Booking entity) {
        return false;
    }

    @Override
    public Booking getSingleEntityById(int id) {
        return null;
    }

    @Override
    public List<Booking> getAllEntities() {
        return null;
    }

    @Override
    public List<Booking> getAllEntitiesById(int id) {
        return null;
    }

    @Override
    public boolean updateEntity(Booking entity) {
        return false;
    }

    @Override
    public boolean deleteEntityById(int id) {
        return false;
    }
}
