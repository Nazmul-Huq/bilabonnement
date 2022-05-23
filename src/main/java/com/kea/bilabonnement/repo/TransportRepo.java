package com.kea.bilabonnement.repo;

import com.kea.bilabonnement.enums.AlarmType;
import com.kea.bilabonnement.model.Alarm;
import com.kea.bilabonnement.model.Invoice;
import com.kea.bilabonnement.model.Transport;
import com.kea.bilabonnement.utility.DatabaseConnectionHandler;

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

public class TransportRepo implements CheckAddAlarm<Transport>{

    @Override
    public List<Transport> getOutdatedEntities(Date date) {
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        List<Transport> transports = new ArrayList<>();

        try {
            Connection connection = DatabaseConnectionHandler.getConnection();
            String query = "SELECT * FROM tbl_transport WHERE tbl_transport.id NOT IN (SELECT transport_id from tbl_car_delivery) AND tbl_transport.delivery_time = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1, sqlDate);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Transport transport = new Transport(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDate(3),
                        resultSet.getDate(4),
                        resultSet.getInt(5)
                );
                transports.add(transport);

            }
        } catch (SQLException e)
        {

        }
        return transports;
    }

    @Override
    public List<Transport> getUnpaidEntities() {
        return null;
    }

    @Override
    public List<Transport> getRecentAlarmsByType(AlarmType alarmType) {
        return null;
    }

}
