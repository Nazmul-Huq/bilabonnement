package com.kea.bilabonnement.service;

import com.kea.bilabonnement.model.Customer;
import com.kea.bilabonnement.repo.BilabonnementCRUD;

/**
 * Author Nazmul
 */

public class CustomerService {

    private final BilabonnementCRUD<Customer> customerRepo;

    public CustomerService(BilabonnementCRUD<Customer> customerRepo) {
        this.customerRepo = customerRepo;
    }


    public boolean addUser(Customer customer) {
        return customerRepo.addEntity(customer);
    }
} // class ends here
