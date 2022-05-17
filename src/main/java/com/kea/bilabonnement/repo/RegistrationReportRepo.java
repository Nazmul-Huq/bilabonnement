package com.kea.bilabonnement.repo;

import com.kea.bilabonnement.model.ConditionReport;
import com.kea.bilabonnement.model.RegReport;
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

public class RegistrationReportRepo implements BilabonnementCRUD<RegReport> {



    Connection conn = DatabaseConnectionHandler.getConnection();
    PreparedStatement prepStmt;
    ResultSet rs;

    //Registration report starts here
    //------------------------------------------------------------------------------------------------------------------

    //Creates a tables with values
    @Override
    public boolean addEntity(RegReport entity) {
        try {
            prepStmt = conn.prepareStatement("INSERT INTO db_bilabonnement.tbl_reg_report (`reg_date`, `employee_id`, `car_reg_number`) VALUES (?,?,?)");

            prepStmt.setInt(1,entity.getRegReportDate());
            prepStmt.setInt(2,entity.getRegReportEmployeeId());
            prepStmt.setInt(3,entity.getRegReportCarRegNr());


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
    public RegReport getSingleEntityById(int number) {

        List<RegReport> singleRegReport = new ArrayList<RegReport>();

        try {
            prepStmt = conn.prepareStatement("SELECT number OR date OR employee_id OR car_reg_number FROM db_bilabonnement.tbl_reg_report");
            rs = prepStmt.executeQuery();


            while (rs.next()) {
                RegReport singleRegReportVar = new RegReport(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4)
                );
                singleRegReport.add(singleRegReportVar);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (RegReport) singleRegReport;
    }

    //Shows all Registration tables
    @Override
    public List<RegReport> getAllEntities() {

        List<RegReport> allRegReports = new ArrayList<RegReport>();

        try {
            prepStmt = conn.prepareStatement("SELECT * FROM db_bilabonnement.tbl_reg_report");
            rs = prepStmt.executeQuery();

            while (rs.next()) {
                RegReport allRegReportsVar = new RegReport(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4)
                );
                allRegReports.add(allRegReportsVar);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allRegReports;

    }

    //Shows all tables by ID
    @Override
    public List<RegReport> getAllEntitiesById(int id) {

        List<RegReport> singleRegReport = new ArrayList<RegReport>();

        try {
            prepStmt = conn.prepareStatement("SELECT number FROM db_bilabonnement.tbl_reg_report");
            rs = prepStmt.executeQuery();

            while (rs.next()) {
                RegReport singleRegReportsVar = new RegReport(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4)
                );
                singleRegReport.add(singleRegReportsVar);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return singleRegReport;
    }

    //Updates a tables
    @Override
    public boolean updateEntity(RegReport entity) {
        try {
            prepStmt = conn.prepareStatement("UPDATE db_bilabonnement.tbl_reg_report SET number=?, reg_date=?, employee_id=?, car_reg_number=?" +
                    "WHERE number, reg_date, employee_id, car_reg_number"
            );

            prepStmt.setInt(1,entity.getRegReportNumber());
            prepStmt.setInt(2,entity.getRegReportDate());
            prepStmt.setInt(3,entity.getRegReportEmployeeId());
            prepStmt.setInt(4,entity.getRegReportCarRegNr());

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

    //Deletes a table
    @Override
    public boolean deleteEntityById(int number) {

        try {
            prepStmt = conn.prepareStatement("DELETE FROM db_bilabonnement.tbl_reg_report WHERE id_number= ?");

            prepStmt.setInt(1,number);


            prepStmt.executeUpdate();


            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    //Registration report ends here
    //------------------------------------------------------------------------------------------------------------------

}
