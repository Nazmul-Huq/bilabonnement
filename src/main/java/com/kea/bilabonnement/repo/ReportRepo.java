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
    Connection conn = DatabaseConnectionHandler.getConnection();
    PreparedStatement prepStmt;
    ResultSet rs;

    // Creates a table with the Values
    @Override
    public boolean addEntity(DamageReport entity) {

        try {
            prepStmt = conn.prepareStatement("INSERT INTO db_bilabonnement.tbl_damage_report VALUES (?,?,?,?,?,?)");

            prepStmt.setInt(1,entity.getNumber());
            prepStmt.setInt(2,entity.getNumber());
            prepStmt.setInt(3,entity.getNumber());
            prepStmt.setInt(4,entity.getNumber());
            prepStmt.setInt(5,entity.getNumber());
            prepStmt.setInt(6,entity.getNumber());

            prepStmt.executeUpdate();

            prepStmt.close();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }


    }

    // Shows one table gotten from ID number
    @Override
    public DamageReport getSingleEntityById(int id) {

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
        return (DamageReport) singleDamageReport;
    }

    @Override
    public List<DamageReport> getallEntities() {
        return null;
    }

    @Override
    public List<DamageReport> getAllEntities() {

        List<DamageReport> allDamageReports = new ArrayList<DamageReport>();

        try {
            prepStmt = conn.prepareStatement("SELECT * FROM db_bilabonnement.tbl_damage_report");
            rs = prepStmt.executeQuery();

            while (rs.next()) {
                DamageReport allDamageReportsVar = new DamageReport(
                        rs.getInt(0),
                        rs.getString(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5)
                );
                allDamageReports.add(allDamageReportsVar);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return allDamageReports;
    }

    @Override
    public List<DamageReport> getAllEntitiesById(int id) {
        return null;
    }

    @Override
    public boolean updateEntity(DamageReport entity) {
        return false;
    }

    @Override
    public boolean deleteEntityById(int id) {
        return false;
    }
}
