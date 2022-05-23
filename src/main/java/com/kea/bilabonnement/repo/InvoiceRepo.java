package com.kea.bilabonnement.repo;

import com.kea.bilabonnement.enums.AlarmType;
import com.kea.bilabonnement.model.Invoice;
import com.kea.bilabonnement.model.InvoicePaymentDate;
import com.kea.bilabonnement.utility.DatabaseConnectionHandler;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Author Nazmul
 */

@Repository
public class InvoiceRepo implements CheckAddAlarm<Invoice>, BilabonnementCRUD<Invoice>{

    Connection connection = DatabaseConnectionHandler.getConnection();

    /**
     * Get all outdated invoices from database and return a list
     * @param date
     * @return
     */
    @Override
    public List<Invoice> getOutdatedEntities(Date date) {
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        List<Invoice> invoices = new ArrayList<>();


        try {
            String query = "select * from tbl_invoice where tbl_invoice.invoice_number NOT IN (select invoice_number from tbl_payment) and tbl_invoice.payment_deadline = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1, sqlDate);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Invoice invoice = new Invoice(
                        resultSet.getInt(1),
                        resultSet.getDate(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5),
                        resultSet.getDate(6),
                        resultSet.getInt(7),
                        resultSet.getInt(8),
                        resultSet.getInt(9),
                        resultSet.getInt(10)
                        );
                invoices.add(invoice);

            }
        } catch (SQLException e)
        {
            System.out.println("Something wrong with database");
        }
        return invoices;
    }

    /**
     * get all invoices which are yet not paid
     * @return
     */
    @Override
    public List<Invoice> getUnpaidEntities() {
        List<Invoice> invoices = new ArrayList<>();


        try {
            String query = "select * from tbl_invoice where tbl_invoice.invoice_number NOT IN (select invoice_number from tbl_payment)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Invoice invoice = new Invoice(
                        resultSet.getInt(1),
                        resultSet.getDate(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5),
                        resultSet.getDate(6),
                        resultSet.getInt(7),
                        resultSet.getInt(8),
                        resultSet.getInt(9),
                        resultSet.getInt(10)
                );
                invoices.add(invoice);

            }
        } catch (SQLException e)
        {
            System.out.println("Something wrong with database");
        }
        return invoices;
    }

    @Override
    public List<Invoice> getRecentAlarmsByType(AlarmType alarmType) {
        return null;
    }

    /**
     * add an invoice to the database
     * @param entity
     * @return
     */
    @Override
    public boolean addEntity(Invoice entity) {
        try{
            String query = " insert into `tbl_invoice` (invoice_date, invoice_receiver, invoice_type, payment_amount, payment_deadline, car_reg_number, employee_id, agreement_number, customer_id)" +
                    " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // create the mysql insert prepared statement
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setDate (1, (java.sql.Date) entity.getInvoiceDate());
            preparedStmt.setString(2, entity.getInvoiceReceiver());
            preparedStmt.setString (3, entity.getInvoiceType());
            preparedStmt.setInt   (4, entity.getPaymentAmount());
            preparedStmt.setDate   (5, (java.sql.Date)entity.getPaymentDeadline());
            preparedStmt.setInt   (6, entity.getCarRegNumber());
            preparedStmt.setInt   (7, entity.getEmployeeId());
            preparedStmt.setInt(8, entity.getAgreementNumber());
            preparedStmt.setInt(9, entity.getCustomerId());

            // execute the prepared statement
            preparedStmt.executeUpdate();
            return true;
        } catch (SQLException e){
            return false;
        }
    }

    /**
     * get an invoice by invoice number and return it
     * @param id
     * @return
     */
    @Override
    public Invoice getSingleEntityById(int id) {
        Invoice invoice = new Invoice();
        try {
            Connection connection = DatabaseConnectionHandler.getConnection();
            String sql = "SELECT * FROM tbl_invoice WHERE invoice_number=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){

                invoice.setInvoiceNumber(resultSet.getInt(1));
                invoice.setInvoiceDate(resultSet.getDate(2));
                invoice.setInvoiceReceiver(resultSet.getString(3));
                invoice.setInvoiceType(resultSet.getString(4));
                invoice.setPaymentAmount(resultSet.getInt(5));
                invoice.setPaymentDeadline(resultSet.getDate(6));
                invoice.setCarRegNumber(resultSet.getInt(7));
                invoice.setEmployeeId(resultSet.getInt(8));
                invoice.setAgreementNumber(resultSet.getInt(9));
                invoice.setCustomerId(resultSet.getInt(10));
            }
            return invoice;
        } catch (SQLException e) {
            return invoice;
        }

    }

    @Override
    public List<Invoice> getAllEntities() {
        return null;
    }

    @Override
    public List<Invoice> getAllEntitiesById(int id) {
        return null;
    }

    @Override
    public boolean updateEntity(Invoice entity) {
        return false;
    }

    @Override
    public boolean deleteEntityById(int id) {
        return false;
    }
} // class ends here

