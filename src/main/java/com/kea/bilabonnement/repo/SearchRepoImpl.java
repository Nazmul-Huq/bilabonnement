package com.kea.bilabonnement.repo;

import com.kea.bilabonnement.model.Car;
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

public class SearchRepoImpl implements SearchRepo{

    private final Connection connection = DatabaseConnectionHandler.getConnection();

    /**
     * fina a car by given car brand(s) and fuel type(s)
     * if none provide then return all available car
     * @param carBrand
     * @param fuelType
     * @return
     */
    @Override
    public List<Car> findAvailableCar(List<String> carBrand, List<String> fuelType) {

        List<Car> availableCars = new ArrayList<>();

        try{
            /*
                select reg_number
                from tbl_car
                join tbl_car_current_status
                on tbl_car.reg_number=tbl_car_current_status.car_reg_number
                WHERE tbl_car_current_status.rent_status='available'
                AND tbl_car.fuel_type= 'electric'  OR tbl_car.fuel_type ='diesel'
                AND tbl_car.car_brand= ('volvo');
             */
            String query = "select reg_number from tbl_car join tbl_car_current_status on tbl_car.reg_number=tbl_car_current_status.car_reg_number WHERE tbl_car_current_status.rent_status='available'";

            PreparedStatement preparedStmt = connection.prepareStatement(query);
            //preparedStmt.setString(1, "available");
            ResultSet resultSet = preparedStmt.executeQuery();
            while (resultSet.next()){
                Car car = new Car(
                        resultSet.getInt(1),
                        resultSet.getString("car_brand"),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getInt(6),
                        resultSet.getString(7),
                        resultSet.getInt(8),
                        resultSet.getInt(9),
                        resultSet.getInt(10),
                        resultSet.getInt(11),
                        resultSet.getString(12),
                        resultSet.getDate(13)
                        );
                availableCars.add(car);
            }
            return availableCars;
        } catch (SQLException e){
            return availableCars;
        }
    }
}
