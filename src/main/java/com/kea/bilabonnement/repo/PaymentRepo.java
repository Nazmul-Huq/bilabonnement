package com.kea.bilabonnement.repo;

import com.kea.bilabonnement.model.Payment;
import com.kea.bilabonnement.model.RentingAgreement;
import com.kea.bilabonnement.utility.DatabaseConnectionHandler;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PaymentRepo implements BilabonnementCRUD<Payment> {

    Connection conn = DatabaseConnectionHandler.getConnection();
    PreparedStatement prepStmt;
    ResultSet rs;

    @Override
    public boolean addEntity(Payment entity) {

        try {
            prepStmt = conn.prepareStatement("INSERT INTO db_bilabonnement.tbl_payment(" +
                    "`id`, " +
                    "`invoice_date`, " +
                    "`pay_date`, " +
                    "`invoice_number`) " +
                    "VALUES (?, ?, ?, ?)");
            prepStmt.setInt(1, entity.getId());
            prepStmt.setDate(2, (Date) entity.getInvoiceDate());
            prepStmt.setDate(3, (Date) entity.getPayDate());
            prepStmt.setInt(4, entity.getInvoiceNumber());

            prepStmt.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Payment getSingleEntityById(int id) {

        List<Payment> getSinglePayment = new ArrayList<>();

        try {
            prepStmt = conn.prepareStatement("SELECT * FROM db_bilabonnement.tbl_payment WHERE id=) + id");
            rs = prepStmt.executeQuery();

            while(rs.next()){
                rs.getInt("id");
                rs.getDate("invoice_date");
                rs.getDate("pay_date");
                rs.getInt("invoice_number");

                Payment singlePayments = new Payment();
                getSinglePayment.add(singlePayments);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return (Payment) getSinglePayment;
    }

    @Override
    public List<Payment> getAllEntities() {

         List<Payment> getAllPayments = new ArrayList<>();

         try{
             prepStmt = conn.prepareStatement("SELECT * FROM db_bilabonnement.tbl_payment");
             rs = prepStmt.executeQuery();

             while(rs.next()){
                 rs.getInt("id");
                 rs.getDate("invoice_date");
                 rs.getDate("pay_date");
                 rs.getInt("invoice_number");

                 Payment allPayments = new Payment();
                 getAllPayments.add(allPayments);
             }
         }
         catch (Exception e){
             e.printStackTrace();
         }
         return getAllPayments;
    }

    @Override
    public List<Payment> getAllEntitiesById(int id) {
        return null;
    }

    @Override
    public boolean updateEntity(Payment entity) {

        try{
            prepStmt = conn.prepareStatement("UPDATE db_bilabonnement.tbl_payment SET invoice_date=?, pay_date=? WHERE (invoice_number=?)");

            prepStmt.setDate(1, (Date) entity.getInvoiceDate());
            prepStmt.setDate(2, (Date) entity.getPayDate());

            prepStmt.executeUpdate();
            System.out.println("Tabellen er opdateret");
            }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteEntityById(int id) {
        return false;
    }

    public List<RentingAgreement> getOverviewOfPayments(){

        List<RentingAgreement> overviewOfPayments = new ArrayList<>();

        try{
            prepStmt = conn.prepareStatement("SELECT price " +
                    "FROM tbl_registration_rent AS reg" +
                    "INNER JOIN tbl_renting_agreement as agree" +
                    "ON tbl_reg.car_reg_number = agree.car_reg_number");

            rs = prepStmt.executeQuery();

            while(rs.next()){
                int price = rs.getInt("price");

                RentingAgreement payment = new RentingAgreement(price);
                overviewOfPayments.add(payment);
            }
            return overviewOfPayments;
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Noget gik galt med at hente oversigten over betaling");
        }
        return null;
    }
}
