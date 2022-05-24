package com.kea.bilabonnement.repo;

public interface LoginRepo {

    /**
     * Verify the customer login
     * if username and password match, then return the customer's id
     * else return 0
     */
    public int verifyCustomerLogin(String username, String password);

    /**
     * Verify the employee login
     * if username and password match, then return the employee id
     * else return 0
     */
    public int verifyEmployeeLogin(String username, String password);

}
