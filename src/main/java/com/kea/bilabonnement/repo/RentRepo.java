package com.kea.bilabonnement.repo;

import com.kea.bilabonnement.model.RentingAgreement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class RentRepo implements BilabonnementCRUD<RentingAgreement> {

    Connection conn;
    PreparedStatement prepStmt;
    ResultSet rs;
    String sqlString;


    @Override
    public boolean addEntity(RentingAgreement entity) {

        try{
            prepStmt = conn.prepareStatement("INSERT INTO db_bilabonnement.tbl_renting_agreement VALUES (?, ?, ?, ?, ?, )");

            prepStmt.setInt(1, entity.getPrice());
            prepStmt.setString(2, entity.getDescription());
            prepStmt.setInt(3, entity.getCustomerId());
            prepStmt.setInt(4, entity.getCarRegNumber());
            prepStmt.setInt(5, entity.getEmployeeId());

            prepStmt.executeUpdate();
            conn.close();

            return true;

        }
        catch (SQLException e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public RentingAgreement getSingleEntityById(int id) {

        List<RentingAgreement> singleRentingAgreement = new ArrayList<>();

        try{
            prepStmt = conn.prepareStatement("SELECT * FROM tbl_renting_agreement WHERE customer_id=" + id);
            rs = prepStmt.executeQuery();

            if (rs.next() == false){
                conn.close();
            } else {
                rs.getInt("agreement_number");
                rs.getInt("price");
                rs.getString("description");
                rs.getInt("customer_id");
                rs.getInt("car_reg_number");
                rs.getInt("employee_id");

                RentingAgreement singleRentingAgreements = new RentingAgreement();
                singleRentingAgreement.add(singleRentingAgreements);

                conn.close();
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<RentingAgreement> getAllEntities() {


        return null;
    }

    @Override
    public List<RentingAgreement> getAllEntitiesById(int id) {
        return null;
    }

    @Override
    public boolean updateEntity(RentingAgreement entity) {
        return false;
    }

    @Override
    public boolean deleteEntityById(int id) {
        return false;
    }
}
