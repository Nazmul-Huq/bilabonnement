package com.kea.bilabonnement.repo;

import com.kea.bilabonnement.model.Lease;
import com.kea.bilabonnement.utility.DatabaseConnectionHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Author Nazmul
 */

public class LeaseRepo implements BilabonnementCRUD<Lease> {

    // instantiate necessary objects
    private final Connection connection = DatabaseConnectionHandler.getConnection();


    /**
     * add a lease to the databse
     * @param entity
     * @return
     */
    @Override
    public boolean addEntity(Lease entity) {
        try{
            String query = " insert into `tbl_lease` (" +
                    "`leasing_price`, `leasing_company`, `leasing_start_date`, `car_reg_number`)" +
                    " values (?, ?, ?, ?)";

            // create the mysql insert prepared statement
            PreparedStatement preparedStmt = connection.prepareStatement(query);

            preparedStmt.setInt (1, entity.getLeasingPrice());
            preparedStmt.setString (2, entity.getLeasingCompany());
            preparedStmt.setDate   (3, entity.getLeasingStartDate());
            preparedStmt.setInt   (4, entity.getCarRegNumber());

            // execute the prepared statement
            preparedStmt.executeUpdate();
            return true;
        } catch (SQLException e){
            return false;
        }
    }

    @Override
    public Lease getSingleEntityById(int id) {
        return null;
    }

    @Override
    public List<Lease> getAllEntities() {
        return null;
    }

    @Override
    public List<Lease> getAllEntitiesById(int id) {
        return null;
    }

    /**
     * update the database when a lease is finished
     * @param entity
     * @return
     */
    @Override
    public boolean updateEntity(Lease entity) {
        try{

            String query = "UPDATE `tbl_lease` SET `leasing_finish_date` = ? WHERE (`id` = ?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setDate   (1, entity.getLeasingFinishDate());
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
} // class ends here
