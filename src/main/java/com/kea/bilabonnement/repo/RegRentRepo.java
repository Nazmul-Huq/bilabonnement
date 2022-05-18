package com.kea.bilabonnement.repo;

import com.kea.bilabonnement.model.RegRent;
import com.kea.bilabonnement.utility.DatabaseConnectionHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegRentRepo implements BilabonnementCRUD<RegRent> {

    Connection conn = DatabaseConnectionHandler.getConnection();
    PreparedStatement prepStmt;
    ResultSet rs;


    @Override
    public boolean addEntity(RegRent entity) {

        try{
            prepStmt = conn.prepareStatement("INSERT INTO db_bilabonnement.tbl_registration_rent(" +
                    "`id`, " +
                    "`driven_pickup_km`, " +
                    "`pickup_date`, " +
                    "`driven_return_km`, " +
                    "`return_date`, " +
                    "`condition_report`, " +
                    "`car_reg_number`, " +
                    "`customer_id`, " +
                    "`employee_id`) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            prepStmt.setInt(1, entity.getId());
            prepStmt.setDouble(2, entity.getDrivenPickupKm());
            prepStmt.setDate(3, (Date) entity.getPickupDate());
            prepStmt.setDouble(4, entity.getDrivenReturnKm());
            prepStmt.setDate(5, (Date) entity.getReturnDate());
            prepStmt.setString(6, entity.getConditionReport());
            prepStmt.setInt(7, entity.getCarRegNumber());
            prepStmt.setInt(8, entity.getCustomerId());
            prepStmt.setInt(9, entity.getEmployeeId());

            prepStmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public RegRent getSingleEntityById(int id) {

        List<RegRent> singleRentRegistration = new ArrayList<>();

        try{
            prepStmt = conn.prepareStatement("SELECT * FROM db_bilabonnement_tbl_registration_rent WHERE id =" + id);
            rs = prepStmt.executeQuery();

            if(rs.next() == false){
                conn.close();
            } else {
                rs.getInt("id");
                rs.getDouble("driven_pickup_km");
                rs.getDate("pickup_date");
                rs.getDouble("driven_return_km");
                rs.getDate("return_date");
                rs.getString("condition_report");
                rs.getInt("car_reg_number");
                rs.getInt("customer_id");
                rs.getInt("employee_id");

                RegRent singleRentReg = new RegRent();
                singleRentRegistration.add(singleRentReg);

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return (RegRent) singleRentRegistration;
    }

    @Override
    public List<RegRent> getAllEntities() {

        List<RegRent> allRentRegistration = new ArrayList<>();

        try {
            prepStmt = conn.prepareStatement("SELECT * FROM db_bilabonnement.tbl_registration_rent");
            rs = prepStmt.executeQuery();

            if (rs.next() == false){
                conn.close();
            } else {
                rs.getInt("id");
                rs.getDouble("driven_pickup_km");
                rs.getDate("pickup_date");
                rs.getDouble("driven_return_km");
                rs.getDate("return_date");
                rs.getString("condition_report");
                rs.getInt("car_reg_number");
                rs.getInt("customer_id");
                rs.getInt("employee_id");

                RegRent allRentReg = new RegRent();
                allRentRegistration.add(allRentReg);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return allRentRegistration;
    }

    @Override
    public List<RegRent> getAllEntitiesById(int id) {

        return null;
    }

    @Override
    public boolean updateEntity(RegRent entity) {

        try{
            prepStmt = conn.prepareStatement("UPDATE db_bilabonnement.tbl_registration_rent " +
                    "SET id=?, driven_pickuo_km=?, pickup_date=?, driven_return_km=?, return_date=?, condition_report=?, car_reg_number=?, customer_id=?, employee_id=?" +
                    "WHERE id, driven_pickuo_km, pickup_date, driven_return_km, return_date, condition_report, car_retg_number, customer_id, employee_id");

            prepStmt.setInt(1, entity.getId());
            prepStmt.setDouble(2, entity.getDrivenPickupKm());
            prepStmt.setDate(3, (Date) entity.getPickupDate());
            prepStmt.setDouble(4, entity.getDrivenReturnKm());
            prepStmt.setDate(5, (Date) entity.getReturnDate());
            prepStmt.setString(6, entity.getConditionReport());
            prepStmt.setInt(7, entity.getCarRegNumber());
            prepStmt.setInt(8, entity.getCustomerId());
            prepStmt.setInt(9, entity.getEmployeeId());

            prepStmt.executeUpdate();
            System.out.println("Tabellen blev succesfuldt updateret");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteEntityById(int id) {

        try {
            prepStmt = conn.prepareStatement("DELETE FROM db_bilabonnement.tbl_registration_rent WHERE id");

            prepStmt.executeUpdate();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
