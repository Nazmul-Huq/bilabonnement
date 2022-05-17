package com.kea.bilabonnement.repo;

import com.kea.bilabonnement.model.RentingAgreement;
import com.kea.bilabonnement.utility.DatabaseConnectionHandler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentRepo implements BilabonnementCRUD<RentingAgreement> {

    Connection conn = DatabaseConnectionHandler.getConnection();
    PreparedStatement prepStmt;
    ResultSet rs;

    @Override
    public boolean addEntity(RentingAgreement entity) {

        try{
            prepStmt = conn.prepareStatement("INSERT INTO db_bilabonnement.tbl_renting_agreement(`price`, `description`, `customer_id`, `car_reg_number`, `employee_id`, `renting_status`) VALUES (?, ?, ?, ?, ?, ?)");

            prepStmt.setInt(1, entity.getPrice());
            prepStmt.setString(2, entity.getDescription());
            prepStmt.setInt(3, entity.getCustomerId());
            prepStmt.setInt(4, entity.getCarRegNumber());
            prepStmt.setInt(5, entity.getEmployeeId());
            prepStmt.setBoolean(6, entity.isRentingStatus());

            prepStmt.executeUpdate();
            //conn.close();

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
            prepStmt = conn.prepareStatement("SELECT * FROM db_bilabonnement.tbl_renting_agreement WHERE customer_id=" + id);
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
                rs.getBoolean("renting_status");

                RentingAgreement singleRentingAgreements = new RentingAgreement();
                singleRentingAgreement.add(singleRentingAgreements);

                //conn.close();
            }

        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Noget gik gal med getSingleEntityById");
        }
        return (RentingAgreement) singleRentingAgreement;
    }

    @Override
    public List<RentingAgreement> getAllEntities() {

        List<RentingAgreement> allRentingAgreement = new ArrayList<>();

        try {
            prepStmt =conn.prepareStatement("SELECT * FROM db_bilabonnement.tbl_renting_agreement");
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
                rs.getBoolean("renting_status");

                RentingAgreement allRentingAgreements = new RentingAgreement();
                allRentingAgreement.add(allRentingAgreements);
                //conn.close();
            }
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Something wet wrong with getAllEntity");
        }

        return allRentingAgreement;
    }

    @Override
    public List<RentingAgreement> getAllEntitiesById(int id) {
        return null;
    }

    @Override
    public boolean updateEntity(RentingAgreement entity) {

        try {

            prepStmt = conn.prepareStatement("UPDATE db_bilabonnement.tbl_renting_agreement SET agreement_number=?, price=?, description=?, customer_id=?, car_reg_number=?, employee_id=?, renting_status=?" +
                    "WHERE agreement_number, price, describtion, customer_id, car_reg_number, employee_id, renting_status");

            prepStmt.setInt(1, entity.getAgreementNumber());
            prepStmt.setInt(2, entity.getPrice());
            prepStmt.setString(3, entity.getDescription());
            prepStmt.setInt(4, entity.getCustomerId());
            prepStmt.setInt(5, entity.getCarRegNumber());
            prepStmt.setInt(6, entity.getEmployeeId());
            prepStmt.setBoolean(7, entity.isRentingStatus());

            int rowUpdate = prepStmt.executeUpdate();
            System.out.println("Tabellen blev succesfuldt updateret");
            //conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Noget gik galt med updateringen");
            return false;
        }
    }

    @Override
    public boolean deleteEntityById(int agreementNumber){
         try {
             prepStmt = conn.prepareStatement("DELETE FROM db_bilabonnement.tbl_renting_agreement WHERE agreement_number");

             int rowDeletion = prepStmt.executeUpdate();
             //conn.close();

        }
         catch (Exception e){
             e.printStackTrace();
             System.out.println("Noget gik galt med sletningen af aftalen");
         }
        return false;
    }
}
