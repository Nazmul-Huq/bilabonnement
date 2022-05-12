package com.kea.bilabonnement.repo;

import com.kea.bilabonnement.model.DamageReport;
import com.kea.bilabonnement.utility.DatabaseConnectionHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReportRepo implements BilabonnementCRUD<DamageReport> {
    // TODO: 11-05-2022 unit testing ctrl-shift-t
    // TODO: 11-05-2022 check if code is right by teacher

    Connection conn = DatabaseConnectionHandler.getConnection();
    PreparedStatement prepStmt;
    ResultSet rs;





    //DamageReport starts here
    //------------------------------------------------------------------------------------------------------------------
    // Creates a table with the Values
    @Override
    public boolean addEntity(DamageReport entity) {

        try {
            prepStmt = conn.prepareStatement("INSERT INTO db_bilabonnement.tbl_damage_report VALUES (?,?,?,?,?,?)");

            prepStmt.setInt(1,entity.getNumber());
            prepStmt.setString(2,entity.getDamageDescription());
            prepStmt.setInt(3,entity.getNoOfDamage());
            prepStmt.setInt(4,entity.getDamageLevel());
            prepStmt.setInt(5,entity.getEmployeeId());
            prepStmt.setInt(6,entity.getCarRegNr());

            prepStmt.executeUpdate();

            prepStmt.close();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }


    }

    // Shows 1 table gotten from ID number
    @Override
    public DamageReport getSingleEntityById(int number) {

        List<DamageReport> singleDamageReport = new ArrayList<DamageReport>();

        try {
            prepStmt = conn.prepareStatement("SELECT number OR damage_description OR no_of_damage OR damage_level OR employee_id OR car_reg_number FROM db_bilabonnement.tbl_damage_report");
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
    public List<DamageReport> getAllEntities() {

        List<DamageReport> allDamageReports = new ArrayList<DamageReport>();

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
            prepStmt = conn.prepareStatement("SELECT number FROM db_bilabonnement.tbl_damage_report");
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
        return singleDamageReport;


    }

    //Updates a table
    @Override
    public boolean updateEntity(DamageReport entity) {

        try {
            prepStmt = conn.prepareStatement("UPDATE db_bilabonnement.tbl_damage_report SET number=?, damage_description=?, " +
             "no_of_damage=?, damage_level=?, employee_id=?, car_reg_number=?" +
             "WHERE number=? OR damage_description=? OR no_of_damage=? OR damage_level OR emloyee_id=? OR car_reg_number"
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

    //Deletes a row by ID number
    @Override
    public boolean deleteEntityById(int number) {

        try {
            prepStmt = conn.prepareStatement("DELETE FROM db_bilabonnement.tbl_damage_report WHERE number");

            int rowsDeleted = prepStmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("row Was successfully deleted");
            }

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    //DamageReport ends here
    //------------------------------------------------------------------------------------------------------------------

}
