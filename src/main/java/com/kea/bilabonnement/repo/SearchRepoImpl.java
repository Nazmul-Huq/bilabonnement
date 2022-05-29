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
     * find a car by given car brand(s) and fuel type(s)
     * if none provide then return all available car
     * Note: the query may not be perfect, it may select more data than it suppose to. Need to modify
     * @param carBrand
     * @param fuelType
     * @return
     */
    @Override
    public List<Car> findAvailableCar(List<String> carBrand, List<String> fuelType) {

        List<Car> availableCars = new ArrayList<>();

        try{
            String query = "select * from tbl_car join tbl_car_current_status on tbl_car.reg_number=tbl_car_current_status.car_reg_number WHERE tbl_car_current_status.rent_status='available'";

            if (carBrand.size() == 1) {
                query = query + " AND tbl_car.car_brand= '"+ carBrand.get(0)+"'";
            } else if (carBrand.size() == 2){
                query = query + " AND tbl_car.car_brand= '"+ carBrand.get(0)+"'";
                query = query + " OR tbl_car.car_brand ='"+carBrand.get(1)+"'";
            } else if (carBrand.size() == 3){
                query = query + " AND tbl_car.car_brand= '"+ carBrand.get(0)+"'";
                query = query + " OR tbl_car.car_brand ='"+carBrand.get(1)+"'";
                query = query + " OR tbl_car.car_brand ='"+carBrand.get(2)+"'";
            }else if (carBrand.size() == 4){
                query = query + " AND tbl_car.car_brand= '"+ carBrand.get(0)+"'";
                query = query + " OR tbl_car.car_brand ='"+carBrand.get(1)+"'";
                query = query + " OR tbl_car.car_brand ='"+carBrand.get(2)+"'";
                query = query + " OR tbl_car.car_brand ='"+carBrand.get(3)+"'";
            }

            if (fuelType.size() == 1) {
                query = query + " AND tbl_car.fuel_type= '"+ fuelType.get(0)+"'";
            } else if (fuelType.size() == 2){
                query = query + " AND tbl_car.fuel_type= '"+ fuelType.get(0)+"'";
                query = query + " OR tbl_car.fuel_type ='"+fuelType.get(1)+"'";
            } else if (fuelType.size() == 3){
                query = query + " AND tbl_car.fuel_type= '"+ fuelType.get(0)+"'";
                query = query + " OR tbl_car.fuel_type ='"+fuelType.get(1)+"'";
                query = query + " OR tbl_car.fuel_type ='"+fuelType.get(2)+"'";
            }else if (fuelType.size() == 4){
                query = query + " AND tbl_car.fuel_type= '"+ fuelType.get(0)+"'";
                query = query + " OR tbl_car.fuel_type ='"+ fuelType.get(1)+"'";
                query = query + " OR tbl_car.fuel_type ='"+ fuelType.get(2)+"'";
                query = query + " OR tbl_car.fuel_type ='"+ fuelType.get(3)+"'";
            }


            PreparedStatement preparedStmt = connection.prepareStatement(query);
            //preparedStmt.setString(1, "available");
            ResultSet resultSet = preparedStmt.executeQuery();
            while (resultSet.next()){
                  Car car = new Car(
                        resultSet.getInt(1),
                        resultSet.getString(2),
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
