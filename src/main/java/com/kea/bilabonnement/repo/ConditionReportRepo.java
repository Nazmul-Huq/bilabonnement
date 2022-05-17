package com.kea.bilabonnement.repo;

import com.kea.bilabonnement.model.ConditionReport;
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

public class ConditionReportRepo implements BilabonnementCRUD<ConditionReport> {


    Connection conn = DatabaseConnectionHandler.getConnection();
    PreparedStatement prepStmt;
    ResultSet rs;



    //ConditionReport starts here
    //------------------------------------------------------------------------------------------------------------------

    //Creates a Table with the values
    @Override
    public boolean addEntity(ConditionReport entity) {
        try {
            prepStmt = conn.prepareStatement("INSERT INTO db_bilabonnement.tbl_condition_report (`condition_date`, `condition_description`, `condition_level`, `employee_id`, `car_reg_number`) VALUES (?,?,?,?,?)");

            prepStmt.setInt(1,entity.getConditionDate());
            prepStmt.setString(2,entity.getConditionDescription());
            prepStmt.setInt(3,entity.getConditionLevel());
            prepStmt.setInt(4,entity.getConditionEmployeeId());
            prepStmt.setInt(5,entity.getConditionCarRegNr());

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
    public ConditionReport getSingleEntityById(int number) {

        List<ConditionReport> singleConditionReport = new ArrayList<ConditionReport>();

        try {
            prepStmt = conn.prepareStatement("SELECT number OR condition_date OR condition_description  OR condition_level OR employee_id OR car_reg_number FROM db_bilabonnement.tbl_condition_report");
            rs = prepStmt.executeQuery();


            while (rs.next()) {
                ConditionReport singleConditionReportVar = new ConditionReport(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6)
                );
                singleConditionReport.add(singleConditionReportVar);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (ConditionReport) singleConditionReport;


    }

    //Shows all condition tables
    @Override
    public List<ConditionReport> getAllEntities() {

        List<ConditionReport> allConditionReports = new ArrayList<ConditionReport>();

        try {
            prepStmt = conn.prepareStatement("SELECT * FROM db_bilabonnement.tbl_condition_report");
            rs = prepStmt.executeQuery();

            while (rs.next()) {
                ConditionReport allConditionReportsVar = new ConditionReport(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6)
                );
                allConditionReports.add(allConditionReportsVar);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return allConditionReports;

    }

    //Shows all tables by ID
    @Override
    public List<ConditionReport> getAllEntitiesById(int number) {

        List<ConditionReport> singleConditionReport = new ArrayList<ConditionReport>();

        try {
            prepStmt = conn.prepareStatement("SELECT number FROM db_bilabonnement.tbl_condition_report");
            rs = prepStmt.executeQuery();

            while (rs.next()) {
                ConditionReport singleConditionReportsVar = new ConditionReport(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6)
                );
                singleConditionReport.add(singleConditionReportsVar);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return singleConditionReport;

    }

    //updates a table
    @Override
    public boolean updateEntity(ConditionReport entity) {
        try {
            prepStmt = conn.prepareStatement("UPDATE db_bilabonnement.tbl_condition_report SET number=?, condition_date=?, condition_description=?, " +
                    "condition_level=?, employee_id=?, car_reg_number=?" +
                    "WHERE number, condition_date, condition_description, condition_level, employee_id, car_reg_number"
            );

            prepStmt.setInt(1,entity.getConditionNumber());
            prepStmt.setInt(2,entity.getConditionDate());
            prepStmt.setString(3,entity.getConditionDescription());
            prepStmt.setInt(4,entity.getConditionLevel());
            prepStmt.setInt(5,entity.getConditionEmployeeId());
            prepStmt.setInt(6,entity.getConditionCarRegNr());

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

    //Deletes a table by id number
    @Override
    public boolean deleteEntityById(int number) {

        try {
            prepStmt = conn.prepareStatement("DELETE FROM db_bilabonnement.tbl_condition_report WHERE id_number= ?");

            prepStmt.setInt(1,number);


            prepStmt.executeUpdate();


            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    //ConditionReport ends here
    //------------------------------------------------------------------------------------------------------------------

}
