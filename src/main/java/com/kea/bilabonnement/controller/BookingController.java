package com.kea.bilabonnement.controller;

import com.kea.bilabonnement.model.Car;
import com.kea.bilabonnement.repo.SearchRepo;
import com.kea.bilabonnement.repo.SearchRepoImpl;
import com.kea.bilabonnement.service.BookingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Author Nazmul
 */

@Controller
@RequestMapping("/booking")
public class BookingController {

    // instantiates objects
    private final SearchRepo searchRepo = new SearchRepoImpl();
    private final BookingService bookingService = new BookingService(searchRepo);

    // show the form to search a car
    @GetMapping("/book-car")
    public String showBookCarForm(){
        return "/booking/book-car";
    }

    @PostMapping("/book-car")
    public String bookCar(
            @RequestParam List<String> carBrand,
            @RequestParam List<String> fuelType
    ){

        List<Car> availableCars = bookingService.getAvailableCar(carBrand, fuelType);
        for (Car car:availableCars) {
            System.out.println(car);
        }

        return "/booking/book-car";
    }

}
