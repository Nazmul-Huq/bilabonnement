package com.kea.bilabonnement.repo;

import com.kea.bilabonnement.model.Car;

import java.util.List;

/**
 * Author Nazmul
 */
public interface SearchRepo {

    public List<Car> findAvailableCar(List<String> carBrand, List<String> fuelType);

}
