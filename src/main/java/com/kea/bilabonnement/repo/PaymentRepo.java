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

        try{
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
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Der gik noget galt med at tilføje en betaling");
        }
        return false;
    }

    @Override
    public Payment getSingleEntityById(int id) {

        List<Payment> getSinglePayment = new ArrayList<>();

        try{
            prepStmt = conn.prepareStatement("SELECT * FROM db_bilabonnement.tbl_payment WHERE id=) + id");
            rs = prepStmt.executeQuery();
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Noget gik galt med at hente en enkel betaling");
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
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Noget gik galt med at hente alle betalinger");
        }
        return getAllPayments;
    }

    @Override
    public List<Payment> getAllEntitiesById(int id) {

        List<Payment> getAllPaymentsById = new ArrayList<>();

        try{
            prepStmt = conn.prepareStatement("SELECT * FROM db_bilabonnement.tbl_payment WHERE id=) + id");
            rs = prepStmt.executeQuery();

            while(rs.next()){
                rs.getInt("id");
                rs.getDate("invoice_date");
                rs.getDate("pay_date");
                rs.getInt("invoice_number");

                Payment allPaymentById = new Payment();
                getAllPaymentsById.add(allPaymentById);
            }

        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Noget gik galt med at hente alle betalinger ved Id");
        }

        return getAllPaymentsById;
    }

    @Override
    public boolean updateEntity(Payment entity) {

        try{
            prepStmt = conn.prepareStatement("UPDATE db_bilabonnemt.tbl_payment SET invoice_date=?, pay_date=? WHERE (invoice_number=?)");

            prepStmt.setDate(1, (Date) entity.getInvoiceDate());
            prepStmt.setDate(2, (Date) entity.getPayDate());

            prepStmt.executeUpdate();
            System.out.println("Tabellen er opdateret");
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Noget gik galt med at opdatere tabellen");
        }
        return false;
    }

    @Override
    public boolean deleteEntityById(int id) {

        try{
            prepStmt = conn.prepareStatement("DELETE FROM db_bilabonnement.tbl_payment WHERE id");
            prepStmt.executeUpdate();
            System.out.println("Betalingen er slettet");
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Noget gik galt med sletningen af betalingen");
        }
        return false;
    }

    public List<RentingAgreement>getTotalPayment(){

        List<RentingAgreement>overviewOfPayments = new ArrayList<>();

        try{
            prepStmt = conn.prepareStatement("SELECT sum(price) AS sumAmount FROM tbl_renting_agreement");
            rs = prepStmt.executeQuery();

            while (rs.next()){
                RentingAgreement totalPayments = new RentingAgreement(rs.getInt("sumAmount"));
                overviewOfPayments.add(totalPayments);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return overviewOfPayments;
    }

    public List<RentingAgreement>getOverviewOfPayments(){

        List<RentingAgreement>overviewOfPayments = new ArrayList<>();

        try {
            prepStmt = conn.prepareStatement("SELECT car_reg_number, price FROM tbl_renting_agreement");
            rs = prepStmt.executeQuery();

            while (rs.next()) {
                RentingAgreement payments = new RentingAgreement(
                        rs.getInt("car_reg_number"),
                        rs.getInt("price"));
                overviewOfPayments.add(payments);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return overviewOfPayments;
    }

}

