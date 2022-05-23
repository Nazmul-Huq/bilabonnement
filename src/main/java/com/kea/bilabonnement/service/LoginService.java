package com.kea.bilabonnement.service;

import com.kea.bilabonnement.repo.LoginRepoImpl;

/**
 * Author Nazmul
 */
public class LoginService {

    // instantiate necessary objectss
    LoginRepoImpl loginRepo;

    public LoginService(LoginRepoImpl loginRepo) {
        this.loginRepo = loginRepo;
    }

    /**
     * verify the customer's login and return customer id
     * @param username
     * @param password
     * @return
     */
    public int verifyCustomerLogin(String username, String password){
        return loginRepo.verifyCustomerLogin(username, password);
    }

    /**
     * verify the employee login and return employee id
     * @param username
     * @param password
     * @return
     */
    public int verifyAdminLogin(String username, String password){
        return loginRepo.verifyAdminLogin(username, password);
    }
}
