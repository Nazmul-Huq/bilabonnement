package com.kea.bilabonnement.service;

import com.kea.bilabonnement.model.Car;
import com.kea.bilabonnement.repo.SearchRepo;

import java.util.List;

/**
 * Author Nazmul
 */

public class BookingService {

    private final SearchRepo searchRepo;

    public BookingService(SearchRepo searchRepo) {
        this.searchRepo = searchRepo;
    }

    public List<Car> getAvailableCar(List<String> carBrand, List<String> fuelType) {

        return searchRepo.findAvailableCar(carBrand, fuelType);
    }
}
