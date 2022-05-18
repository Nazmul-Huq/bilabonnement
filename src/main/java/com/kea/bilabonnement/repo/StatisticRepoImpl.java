package com.kea.bilabonnement.repo;

import com.kea.bilabonnement.model.InvoicePaymentDate;
import com.kea.bilabonnement.utility.DatabaseConnectionHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StatisticRepoImpl implements StatisticRepo{

    /**
     * get invoice and payment date
     * return them as a list of InvoicePaymentDate model
     * @return
     */
    @Override
    public List<InvoicePaymentDate> getAllInvoicePaymentDate() {
        List<InvoicePaymentDate> invoicePaymentDates = new ArrayList<>();
        try {
            Connection connection = DatabaseConnectionHandler.getConnection();
            String sql = "SELECT tbl_invoice.payment_deadline, tbl_payment.pay_date FROM tbl_invoice join tbl_payment on tbl_invoice.invoice_number=tbl_payment.invoice_number";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                InvoicePaymentDate invoicePaymentDate = new InvoicePaymentDate(
                    resultSet.getDate(1),
                    resultSet.getDate(2)
                );

                invoicePaymentDates.add(invoicePaymentDate);
            }
        } catch (SQLException e) {
            System.out.println("database connection failed");
        }
        return invoicePaymentDates;
    }

    /**
     * get car registration and renting time as date
     * convert them to string and return them
     * @return
     */
    @Override
    public List<String> getAllTransportDeliveryTime() {
        List<String> deliveryTimes = new ArrayList<>();
        try {
            Connection connection = DatabaseConnectionHandler.getConnection();
            String sql = "SELECT tbl_reg_rent.pickup_date, tbl_car.reg_date  FROM tbl_car join tbl_reg_rent on tbl_car.reg_number=tbl_reg_rent.car_reg_number";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Date carRentDate = resultSet.getDate(1);
                Date carRegDate = resultSet.getDate(2);

                String carRegRent = carRentDate.toString()+":"+carRegDate.toString();
                deliveryTimes.add(carRegRent);
            }
        } catch (SQLException e) {
            System.out.println("database connection failed");
        }
        return deliveryTimes;
    }
}
