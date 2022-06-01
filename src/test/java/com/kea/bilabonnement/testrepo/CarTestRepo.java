//Forfatter: Sara

package com.kea.bilabonnement.testrepo;

import com.kea.bilabonnement.model.Car;
import com.kea.bilabonnement.repo.BilabonnementCRUD;

import java.sql.Date;
import java.util.List;

public class CarTestRepo implements BilabonnementCRUD<Car> {


    @Override
    public boolean addEntity(Car entity) {
        return false;
    }

    @Override
    public Car getSingleEntityById(int id) {
        Date date = new Date(2022-01-01);
        Car car = new Car(12345678, "Mercedes", "A200", "Rød", "Ingen", 12, 200,23000, 300, 5000, "disel", date);
        return car;
    }

    @Override
    public List<Car> getAllEntities() {
        return null;
    }

    @Override
    public List<Car> getAllEntitiesById(int id) {
        return null;
    }

    @Override
    public boolean updateEntity(Car entity) {
        return false;
    }

    @Override
    public boolean deleteEntityById(int id) {
        return false;
    }
}
