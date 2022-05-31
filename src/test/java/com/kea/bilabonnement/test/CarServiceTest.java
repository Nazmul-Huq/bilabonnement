package com.kea.bilabonnement.test;

import com.kea.bilabonnement.model.Car;
import com.kea.bilabonnement.repo.BilabonnementCRUD;
import com.kea.bilabonnement.service.CarService;
import com.kea.bilabonnement.testrepo.CarTestRepo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarServiceTest {

    @Test
    void getSingleCarEntityById(){
        BilabonnementCRUD<Car> carTestRepo = new CarTestRepo();

        CarService carService = new CarService(carTestRepo);
        int regNumber = 12345678;


        Car singleCar = carService.getCarByID(regNumber);

        assertEquals(singleCar.getRegNumber(),regNumber);
    }

}
