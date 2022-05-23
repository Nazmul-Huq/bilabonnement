package com.kea.bilabonnement.repo;

import com.kea.bilabonnement.model.Customer;
import com.kea.bilabonnement.utility.DatabaseConnectionHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Author Nazmul
 */

public class CustomerRepo implements BilabonnementCRUD<Customer> {

    Connection connection = DatabaseConnectionHandler.getConnection();


    /**
     * add a customer to the database
     * @param entity
     * @return
     */
    @Override
    public boolean addEntity(Customer entity) {
        try{
            String query = " insert into `tbl_customer` (name, cpr_number, username, password, address, driving_license, passport_number, phone_number, credit_rating, credit_card)" +
                    " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // create the mysql insert prepared statement
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString (1, entity.getName());
            preparedStmt.setInt(2, entity.getCprNumber());
            preparedStmt.setString (3, entity.getUsername());
            preparedStmt.setString   (4, entity.getPassword());
            preparedStmt.setString   (5, entity.getAddress());
            preparedStmt.setString   (6, entity.getDrivingLicense());
            preparedStmt.setString   (7, entity.getPassportNumber());
            preparedStmt.setInt(8, entity.getPhoneNumber());
            preparedStmt.setInt(9, entity.getCreditRating());
            preparedStmt.setInt(10, entity.getCreditCard());

            // execute the prepared statement
            preparedStmt.executeUpdate();
            return true;
        } catch (SQLException e){
            return false;
        }
    }

    /**
     * get a customer's detail by customer's id
     * @param id
     * @return
     */
    @Override
    public Customer getSingleEntityById(int id) {

        Customer customer = new Customer();
        try {
            String sql = "SELECT * FROM `tbl_customer` WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                customer.setId(resultSet.getInt(1));
                customer.setName(resultSet.getString(2));
                customer.setCprNumber(resultSet.getInt(3));
                customer.setUsername(resultSet.getString(4));
                customer.setPassword(resultSet.getString(5));
                customer.setAddress(resultSet.getString(6));
                customer.setDrivingLicense(resultSet.getString(7));
                customer.setPassportNumber(resultSet.getString(8));
                customer.setPhoneNumber(resultSet.getInt(9));
                customer.setCreditRating(resultSet.getInt(10));
                customer.setCreditCard(resultSet.getInt(11));
            }
            return customer;
        } catch (SQLException e){
            return customer;
        }
    }

    @Override
    public List<Customer> getAllEntities() {
        return null;
    }

    @Override
    public List<Customer> getAllEntitiesById(int id) {
        return null;
    }

    @Override
    public boolean updateEntity(Customer entity) {
        return false;
    }

    @Override
    public boolean deleteEntityById(int id) {
        return false;
    }
} // class ends here
