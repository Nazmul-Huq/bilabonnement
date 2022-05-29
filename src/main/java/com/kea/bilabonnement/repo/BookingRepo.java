package com.kea.bilabonnement.repo;

import com.kea.bilabonnement.model.Booking;
import com.kea.bilabonnement.utility.DatabaseConnectionHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Author Nazmul
 */

public class BookingRepo implements BilabonnementCRUD<Booking> {

    private final Connection connection = DatabaseConnectionHandler.getConnection();

    @Override
    public boolean addEntity(Booking entity) {

        try{
            String query = " insert into `tbl_booking` (`car_reg_number`, `customer_id`)" +
                    " values (?, ?)";

            // create the mysql insert prepared statement
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt (1, entity.getCarRegNumber());
            preparedStmt.setInt (2, entity.getCustomerId());

            // execute the prepared statement
            preparedStmt.executeUpdate();
            return true;
        } catch (SQLException e){
            return false;
        }
    }

    @Override
    public Booking getSingleEntityById(int id) {
        return null;
    }

    @Override
    public List<Booking> getAllEntities() {
        return null;
    }

    @Override
    public List<Booking> getAllEntitiesById(int id) {
        return null;
    }

    @Override
    public boolean updateEntity(Booking entity) {
        return false;
    }

    @Override
    public boolean deleteEntityById(int id) {
        return false;
    }
}
