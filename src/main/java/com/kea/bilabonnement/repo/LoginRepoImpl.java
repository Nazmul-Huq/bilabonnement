package com.kea.bilabonnement.repo;

import com.kea.bilabonnement.model.Customer;
import com.kea.bilabonnement.utility.DatabaseConnectionHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Author Nazmul
 */
public class LoginRepoImpl implements LoginRepo{

    // instantiate necessary object
    private final Connection connection = DatabaseConnectionHandler.getConnection();


    /**
     * Verify the customer login
     * if username and password match, then return the customer's id
     * else return 0
     * @param username
     * @param password
     * @return
     */
    @Override
    public int verifyCustomerLogin(String username, String password){
        int customerId = 0;
        try {
            String sql = "SELECT * FROM `tbl_customer` WHERE username=? AND password=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                customerId = resultSet.getInt(1);
            }
            return customerId;
        } catch (SQLException e){
            return customerId;
        }
    }

    /**
     * Verify the employee login
     * if username and password match, then return the employee id
     * else return 0
     * @param username
     * @param password
     * @return
     */
    @Override
    public int verifyEmployeeLogin(String username, String password){
        int employeeId = 0;
        try {
            String sql = "SELECT * FROM `tbl_employee` WHERE username=? AND password=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                employeeId = resultSet.getInt(1);
            }
            return employeeId;
        } catch (SQLException e){
            return employeeId;
        }
    }

}
