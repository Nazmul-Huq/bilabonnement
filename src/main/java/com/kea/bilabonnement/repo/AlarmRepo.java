package com.kea.bilabonnement.repo;

import com.kea.bilabonnement.enums.AlarmType;
import com.kea.bilabonnement.model.Alarm;
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

public class AlarmRepo implements CheckAddAlarm<Alarm>, BilabonnementCRUD<Alarm>{

    // no implementation
    @Override
    public List<Alarm> getOutdatedEntities(Date date) {
        return null;
    }

    /**
     * get alarms by tpye from database and send returned to alarm service
     * @param alarmType
     * @return
     */
    @Override
    public List<Alarm> getRecentAlarmsByType(AlarmType alarmType) {
        List<Alarm> alarms = new ArrayList<>();
        try {
            Connection connection = DatabaseConnectionHandler.getConnection();
            String sql = "SELECT * FROM `tbl_alarm` WHERE alarm_type=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(alarmType));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Alarm alarm = new Alarm(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDate(3),
                        resultSet.getString(4),
                        AlarmType.valueOf(resultSet.getString(5)),
                        resultSet.getInt(6)
                );
                alarms.add(alarm);
            }
        } catch (SQLException e) {
            System.out.println("database connection failed");
        }
        return alarms;

    }


    /**
     * add a given alarm to the database
     * @param entity
     */
    @Override
    public boolean addEntity(Alarm entity) {
        try {
            Connection connection = DatabaseConnectionHandler.getConnection();

            String sql = "INSERT INTO `tbl_alarm` (`alarm_description`, `alarm_date`, `alarm_reveiver`, `alarm_type`, `car_reg_number`) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, entity.getAlarmDescription());
            preparedStatement.setDate(2, (java.sql.Date) entity.getAlarmDate());
            preparedStatement.setString(3, entity.getAlarmReceiver());
            preparedStatement.setString(4, String.valueOf(entity.getAlarmType()));
            preparedStatement.setInt(5, entity.getCarRegNumber());

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e)
        {
            System.out.println("database connection failed");
            return false;
        }
        return true;
    }

    // no implementation
    @Override
    public Alarm getSingleEntityById(int id) {
        return null;
    }

    /**
     * get all alarms from database and returned to alarm service
     * @return
     */
    @Override
    public List<Alarm> getAllEntities() {
        List<Alarm> alarms = new ArrayList<>();
        try {
            Connection connection = DatabaseConnectionHandler.getConnection();
            String sql = "SELECT * FROM `tbl_alarm`";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Alarm alarm = new Alarm(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDate(3),
                        resultSet.getString(4),
                        AlarmType.valueOf(resultSet.getString(5)),
                        resultSet.getInt(6)
                );
                alarms.add(alarm);
            }
        } catch (SQLException e) {
            System.out.println("database connection failed");
        }
        return alarms;
    }

    // no implementation
    @Override
    public List<Alarm> getAllEntitiesById(int id) {
        return null;
    }

    // no implementation
    @Override
    public boolean updateEntity(Alarm entity) {
        return false;
    }

    // no implementation
    @Override
    public boolean deleteEntityById(int id) {
        return false;
    }
}
