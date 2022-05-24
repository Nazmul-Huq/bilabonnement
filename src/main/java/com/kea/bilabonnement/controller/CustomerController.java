package com.kea.bilabonnement.controller;

import com.kea.bilabonnement.model.Customer;
import com.kea.bilabonnement.repo.BilabonnementCRUD;
import com.kea.bilabonnement.repo.CustomerRepo;
import com.kea.bilabonnement.repo.LoginRepoImpl;
import com.kea.bilabonnement.service.CustomerService;
import com.kea.bilabonnement.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Author Nazmul
 */

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final BilabonnementCRUD<Customer> customerRepo = new CustomerRepo();
    private final CustomerService customerService = new CustomerService(customerRepo);
    private final LoginRepoImpl loginRepo = new LoginRepoImpl();
    private final LoginService loginService = new LoginService(loginRepo);

    // show customer registration page
    @GetMapping("/add-customer")
    public String addCustomer() {
        return "/customer/add-customer";
    }


     @PostMapping("/add-customer")
        public String addCustomerHandler(@ModelAttribute Customer customer) {
        if (customerService.addUser(customer)) {
             return "redirect:/login/login-customer";
         } else {
             return "redirect:/error";
         }
    }


    @GetMapping("/profile-customer")
    public String profileCustomer(){
        return "/customer/profile-customer";
    }


    @GetMapping("/delete-customer")
    public String deleteCustomer(){
        return "/customer/delete-customer";
    }

    @GetMapping("/edit-customer")
    public String editCustomer(){
        return "/customer/edit-customer";
    }


}
