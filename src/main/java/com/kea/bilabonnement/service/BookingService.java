package com.kea.bilabonnement.service;

import com.kea.bilabonnement.model.Booking;
import com.kea.bilabonnement.model.Car;
import com.kea.bilabonnement.repo.BilabonnementCRUD;
import com.kea.bilabonnement.repo.SearchRepo;

import java.util.List;

/**
 * Author Nazmul
 */

public class BookingService {

    /**
     * instantiate necessary objects via constructor
     */
    private final SearchRepo searchRepo;
    private final BilabonnementCRUD<Booking> bookingRepo;
    public BookingService(SearchRepo searchRepo, BilabonnementCRUD<Booking> bookingRepo) {
        this.searchRepo = searchRepo;
        this.bookingRepo = bookingRepo;
    }

    /**
     * get a list of available car based on submitte search criteria
     * @param carBrand
     * @param fuelType
     * @return
     */
    public List<Car> getAvailableCar(List<String> carBrand, List<String> fuelType) {

        return searchRepo.findAvailableCar(carBrand, fuelType);
    }

    /**
     * add a booking into the database (tbl_booking)
     * @param carRegNumber
     * @param customerId
     * @return
     */
    public boolean addBooking(int carRegNumber, int customerId) {
        return bookingRepo.addEntity(new Booking(carRegNumber, customerId));
    }
}
