package com.kea.bilabonnement.repo;

import com.kea.bilabonnement.enums.AlarmType;
import com.kea.bilabonnement.model.Alarm;
import com.kea.bilabonnement.model.Invoice;
import com.kea.bilabonnement.model.Transport;
import com.kea.bilabonnement.utility.DatabaseConnectionHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Author Nazmul
 */

public class TransportRepo implements CheckAddAlarm<Transport>, BilabonnementCRUD<Transport>{

    // instantiate necessary objects
    private final Connection connection = DatabaseConnectionHandler.getConnection();


    @Override
    public List<Transport> getOutdatedEntities(Date date) {
    return null;
    }

    @Override
    public List<Transport> getUnpaidEntities() {
        return null;
    }

    @Override
    public List<Transport> getRecentAlarmsByType(AlarmType alarmType) {
        return null;
    }

    /**
     * add a transport
     * @param entity
     * @return
     */
    @Override
    public boolean addEntity(Transport entity) {
        try{
            String query = " insert into `tbl_transport` (`pickup_date`, `pickup_location`, `delivery_loaction`, `delivery_deadline`, `note`, `delivery_date`, `car_reg_number`)" +
                    " values (?, ?, ?, ?, ?, ?, ?)";

            // create the mysql insert prepared statement
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setDate (1, entity.getPickupDate());
            preparedStmt.setString (2, entity.getPickupLocation());
            preparedStmt.setString(3, entity.getDeliveryLocation());
            preparedStmt.setDate   (4, entity.getDeliveryDeadline());
            preparedStmt.setString   (5, entity.getNote());
            preparedStmt.setDate   (6, entity.getDeliveryDate());
            preparedStmt.setInt   (7, entity.getCarRegNumber());

            // execute the prepared statement
            preparedStmt.executeUpdate();
            return true;
        } catch (SQLException e){
            return false;
        }
    }

    /**
     * get a transport by id
     * @param id
     * @return
     */
    @Override
    public Transport getSingleEntityById(int id) {

        Transport transport = new Transport();

        try{
            String query = "SELECT * FROM `tbl_transport` WHERE id=?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt   (1, id);

            ResultSet resultSet = preparedStmt.executeQuery();
            while (resultSet.next()){
                transport.setId(resultSet.getInt(1));
                transport.setPickupDate(resultSet.getDate(2));
                transport.setPickupLocation(resultSet.getString(3));
                transport.setDeliveryLocation(resultSet.getString(4));
                transport.setDeliveryDeadline(resultSet.getDate(5));
                transport.setNote(resultSet.getString(6));
                transport.setDeliveryDeadline(resultSet.getDate(7));
                transport.setCarRegNumber(resultSet.getInt(8));
            }
            return transport;

        } catch (SQLException e){
            return transport;
        }

    }

    @Override
    public List<Transport> getAllEntities() {
        return null;
    }

    @Override
    public List<Transport> getAllEntitiesById(int id) {
        return null;
    }

    /**
     * update a transport
     * set the final delivery date when a car is delivered
     * @param entity
     * @return
     */
    @Override
    public boolean updateEntity(Transport entity) {
        try{
            String query = "UPDATE `tbl_transport` SET `delivery_date` = ? WHERE (`id` = ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setDate   (1, entity.getDeliveryDate());
            preparedStmt.setInt   (2, entity.getId());
            preparedStmt.executeUpdate();
            return true;
        } catch (SQLException e){
            return false;
        }
    }

    @Override
    public boolean deleteEntityById(int id) {
        return false;
    }
}
