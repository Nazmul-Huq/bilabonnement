package com.kea.bilabonnement.repo;

import com.kea.bilabonnement.model.Employee;
import com.kea.bilabonnement.utility.DatabaseConnectionHandler;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Author Nazmul
 */

public class EmployeeRepo implements BilabonnementCRUD<Employee>{

    Connection connection = DatabaseConnectionHandler.getConnection();


    /**
     * add an employee to the database
     * @param entity
     * @return
     */
    @Override
    public boolean addEntity(Employee entity) {

        try{
            String query = " insert into `tbl_employee` (name, cpr_number, username, password, hire_date, department)" +
                    " values (?, ?, ?, ?, ?, ?)";

            // create the mysql insert prepared statement
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString (1, entity.getName());
            preparedStmt.setInt(2, entity.getCprNumber());
            preparedStmt.setString (3, entity.getUsername());
            preparedStmt.setString   (4, entity.getPassword());
            preparedStmt.setDate   (5, (Date) entity.getHireDate());
            preparedStmt.setString   (6, entity.getDepartment().toString());

            // execute the prepared statement
            preparedStmt.executeUpdate();
            return true;
        } catch (SQLException e){
            return false;
        }

    }

    @Override
    public Employee getSingleEntityById(int id) {
        return null;
    }

    @Override
    public List<Employee> getAllEntities() {
        return null;
    }

    @Override
    public List<Employee> getAllEntitiesById(int id) {
        return null;
    }

    @Override
    public boolean updateEntity(Employee entity) {
        return false;
    }

    @Override
    public boolean deleteEntityById(int id) {
        return false;
    }
}
