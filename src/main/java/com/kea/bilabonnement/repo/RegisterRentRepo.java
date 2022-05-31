package com.kea.bilabonnement.repo;

import com.kea.bilabonnement.model.ConditionReport;
import com.kea.bilabonnement.model.RegisterRent;
import com.kea.bilabonnement.utility.DatabaseConnectionHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegisterRentRepo implements BilabonnementCRUD<RegisterRent> {

    Connection conn = DatabaseConnectionHandler.getConnection();
    PreparedStatement prepStmt;
    ResultSet rs;

    @Override
    public boolean addEntity(RegisterRent entity) {

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
            System.out.println("Noget gik galt med at tlføje en enhed");
        }
        return false;
    }

    @Override
    public RegisterRent getSingleEntityById(int id) {

        List<RegisterRent> singleRentRegistration = new ArrayList<>();

        try{
            prepStmt = conn.prepareStatement("SELECT * FROM db_bilabonnement_tbl_registration_rent WHERE id =" + id);
            rs = prepStmt.executeQuery();

            while(rs.next()){
                rs.getInt("id");
                rs.getDouble("driven_pickup_km");
                rs.getDate("pickup_date");
                rs.getDouble("driven_return_km");
                rs.getDate("return_date");
                rs.getString("condition_report");
                rs.getInt("car_reg_number");
                rs.getInt("customer_id");
                rs.getInt("employee_id");

                RegisterRent singleRentReg = new RegisterRent();
                singleRentRegistration.add(singleRentReg);
            }
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Noget gik galt med finde enkle enheder");
        }
        return (RegisterRent) singleRentRegistration;
    }

    @Override
    public List<RegisterRent> getAllEntities() {

        List<RegisterRent> allRentRegistration = new ArrayList<>();

        try {
            prepStmt = conn.prepareStatement("SELECT * FROM db_bilabonnement.tbl_registration_rent");
            rs = prepStmt.executeQuery();

            while(rs.next()){
                rs.getInt("id");
                rs.getDouble("driven_pickup_km");
                rs.getDate("pickup_date");
                rs.getDouble("driven_return_km");
                rs.getDate("return_date");
                rs.getString("condition_report");
                rs.getInt("car_reg_number");
                rs.getInt("customer_id");
                rs.getInt("employee_id");

                RegisterRent allRentReg = new RegisterRent();
                allRentRegistration.add(allRentReg);
            }
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Noget gik galt med at finde alle enhederne");
        }
        return allRentRegistration;
    }

    @Override
    public List<RegisterRent> getAllEntitiesById(int id) {

        return null;
    }

    @Override
    public boolean updateEntity(RegisterRent entity) {

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
            System.out.println("Noget gik galt med updateringen");
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
            System.out.println("Noget gik galt med sletningen af aftalen");
        }
        return false;
    }

    /*public List<ConditionReport> getConditionReport(){

        List<ConditionReport> conditionsReporter = new ArrayList<>();

        try{
            prepStmt = conn.prepareStatement(
                    "SELECT report.date, report.condition_description, report.condition_level, report.employee_id, report.car_reg_number "
                    + "FROM tbl_registration_rent AS reg"
                    + "INNER JOIN tbl_condition_report AS report"
                    + "ON tbl_reg.car_reg_number = report.car_reg_number");
            rs = prepStmt.executeQuery();

            while (rs.next()){
                int date =rs.getInt("date");
                String description = rs.getString("condition_description");
                int level = rs.getInt("condition_level");
                int employeeId = rs.getInt("employee_id");
                int carRegNumber = rs.getInt("car_reg_number");

                ConditionReport conditionReport = new ConditionReport(date, description, level, employeeId, carRegNumber);
                conditionsReporter.add(conditionReport);

            }
            return conditionsReporter;
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Noget gik galt med at hente tilstandsreporten");
        }
        return null;
    }

     */
}
