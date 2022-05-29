package com.kea.bilabonnement.controller;

import com.kea.bilabonnement.model.Booking;
import com.kea.bilabonnement.model.Car;
import com.kea.bilabonnement.repo.BilabonnementCRUD;
import com.kea.bilabonnement.repo.BookingRepo;
import com.kea.bilabonnement.repo.SearchRepo;
import com.kea.bilabonnement.repo.SearchRepoImpl;
import com.kea.bilabonnement.service.BookingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Author Nazmul
 */

@Controller
@RequestMapping("/booking")
public class BookingController {

    // instantiates objects
    private final SearchRepo searchRepo = new SearchRepoImpl();
    private final BilabonnementCRUD<Booking> bookingRepo = new BookingRepo();
    private final BookingService bookingService = new BookingService(searchRepo, bookingRepo);

    // show the form to search a car
    @GetMapping("/find-car")
    public String showFindCarForm(){
        return "/booking/find-car";
    }

    // find available cars
    @PostMapping("/find-car")
    public String findCar(@RequestParam List<String> carBrand, @RequestParam List<String> fuelType, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("availableCars", bookingService.getAvailableCar(carBrand, fuelType));
        return "redirect:/booking/car-search-result";
    }

    // show the list of the available car
    @GetMapping("/car-search-result")
    public String searchResults(
            @ModelAttribute("availableCars") final List<Car> availableCars,
            Model model
    ){
        model.addAttribute("availableCars", availableCars);
        return "/booking/car-search-result";
    }

    // book the car
    @PostMapping("/book-car")
    public String bookCar(@RequestParam int carRegNumber, Model model){
        model.addAttribute("carRegNumber", carRegNumber);
        return "/booking/book-car-form";
    }

    // handle the booking, insert into the database
    @PostMapping("/final-booking")
    public String finalBooking(@RequestParam int carRegNumber, @RequestParam int customerId){
       boolean isBookingSucceed = bookingService.addBooking(carRegNumber, customerId);
        if (isBookingSucceed) {
            return "/success";
        } else {
            return "/error";
        }

    }

}
