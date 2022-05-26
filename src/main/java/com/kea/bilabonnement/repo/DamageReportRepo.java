package com.kea.bilabonnement.repo;

import com.kea.bilabonnement.model.DamageReport;
import com.kea.bilabonnement.utility.DatabaseConnectionHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
    Author: Mo
 */

public class DamageReportRepo implements BilabonnementCRUD<DamageReport> {



    Connection conn = DatabaseConnectionHandler.getConnection();
    PreparedStatement prepStmt;
    ResultSet rs;


    //DamageReport starts here
    //------------------------------------------------------------------------------------------------------------------

    // Creates a table with the Values
    @Override
    public boolean addEntity(DamageReport entity) {

        try {
            prepStmt = conn.prepareStatement("INSERT INTO db_bilabonnement.tbl_damage_report (`damage_description`, `no_of_damage`, `damage_level`, `employee_id`, `car_reg_number`) VALUES (?,?,?,?,?)");

            prepStmt.setString(1,entity.getDamageDescription());
            prepStmt.setInt(2,entity.getNoOfDamage());
            prepStmt.setInt(3,entity.getDamageLevel());
            prepStmt.setInt(4,entity.getEmployeeId());
            prepStmt.setInt(5,entity.getCarRegNr());

            prepStmt.executeUpdate();

            prepStmt.close();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }


    }

    // Shows 1 value gotten from ID number

    @Override
    public DamageReport getSingleEntityById(int number) {

        List<DamageReport> singleDamageReport = new ArrayList<DamageReport>();

        try {
            prepStmt = conn.prepareStatement("SELECT id_number OR damage_description OR no_of_damage OR damage_level OR employee_id OR car_reg_number FROM db_bilabonnement.tbl_damage_report");
            rs = prepStmt.executeQuery();


            while (rs.next()) {
                DamageReport singleDamageReportVar = new DamageReport(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getInt(5),
                    rs.getInt(6)
                );
                singleDamageReport.add(singleDamageReportVar);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (DamageReport) singleDamageReport;
    }

    //Shows all tables
    @Override
    public ArrayList<DamageReport> getAllEntities() {

        ArrayList<DamageReport> allDamageReports = new ArrayList<DamageReport>();

        try {
            prepStmt = conn.prepareStatement("SELECT * FROM db_bilabonnement.tbl_damage_report");
            rs = prepStmt.executeQuery();

            while (rs.next()) {
                DamageReport allDamageReportsVar = new DamageReport(
                rs.getInt(1),
                rs.getString(2),
                rs.getInt(3),
                rs.getInt(4),
                rs.getInt(5),
                rs.getInt(6)
                );
                allDamageReports.add(allDamageReportsVar);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return allDamageReports;
    }

    //Shows all tables by ID
    @Override
    public List<DamageReport> getAllEntitiesById(int number) {

        List<DamageReport> singleDamageReport = new ArrayList<DamageReport>();

        try {
            prepStmt = conn.prepareStatement("SELECT * FROM db_bilabonnement.tbl_damage_report WHERE id_number = ?");

            prepStmt.setInt(1,number);

            rs = prepStmt.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();

        }
        return singleDamageReport;


    }

    //Updates a table
    @Override
    public boolean updateEntity(DamageReport entity) {

        try {
            prepStmt = conn.prepareStatement("UPDATE db_bilabonnement.tbl_damage_report SET number=?, damage_description=?, " +
             "no_of_damage=?, damage_level=?, employee_id=?, car_reg_number=?" +
             "WHERE id_number=? OR damage_description=? OR no_of_damage=? OR damage_level OR emloyee_id=? OR car_reg_number"
            );

            prepStmt.setInt(1,entity.getNumber());
            prepStmt.setString(2,entity.getDamageDescription());
            prepStmt.setInt(3,entity.getNoOfDamage());
            prepStmt.setInt(4,entity.getDamageLevel());
            prepStmt.setInt(5,entity.getEmployeeId());
            prepStmt.setInt(6,entity.getCarRegNr());

            int rowsUpdated = prepStmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("table was successfully updated");
            }


            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    //Deletes a table by ID number
    @Override
    public boolean deleteEntityById(int number) {

        try {
            prepStmt = conn.prepareStatement("DELETE FROM db_bilabonnement.tbl_damage_report WHERE id_number= ?");

            prepStmt.setInt(1,number);

            
            prepStmt.executeUpdate();


            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    //DamageReport ends here
    //------------------------------------------------------------------------------------------------------------------

}
