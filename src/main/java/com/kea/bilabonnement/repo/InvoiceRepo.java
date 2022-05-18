package com.kea.bilabonnement.repo;

import com.kea.bilabonnement.enums.AlarmType;
import com.kea.bilabonnement.model.Alarm;
import com.kea.bilabonnement.model.Invoice;
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
public class InvoiceRepo implements CheckAddAlarm<Invoice> {




    @Override
    public List<Invoice> getOutdatedEntities(Date date) {
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        List<Invoice> invoices = new ArrayList<>();


        try {
            Connection connection = DatabaseConnectionHandler.getConnection();
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

    @Override
    public List<Invoice> getRecentAlarmsByType(AlarmType alarmType) {
        return null;
    }

} // class ends here

