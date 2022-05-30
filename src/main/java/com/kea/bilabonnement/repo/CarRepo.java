package com.kea.bilabonnement.repo;

import com.kea.bilabonnement.model.Car;
import com.kea.bilabonnement.utility.DatabaseConnectionHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarRepo implements BilabonnementCRUD<Car>{
    Connection conn = DatabaseConnectionHandler.getConnection();
    PreparedStatement prepStmt;
    ResultSet rs;

    @Override
    public boolean addEntity(Car entity) {

        try {
            prepStmt = conn.prepareStatement("INSERT INTO db_bilabonnement.tbl_car VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");

            prepStmt.setInt(1,entity.getRegNumber());
            prepStmt.setString(2,entity.getCarBrand());
            prepStmt.setString(3,entity.getCarModel());
            prepStmt.setString(4,entity.getCarColor());
            prepStmt.setString(5,entity.getAccessories());
            prepStmt.setInt(6,entity.getChasisLevel());
            prepStmt.setInt(7,entity.getDrivenKM());
            prepStmt.setInt(8,entity.getTax());
            prepStmt.setInt(9,entity.getCo2Emission());
            prepStmt.setInt(10,entity.getStelPrice());
            prepStmt.setString(11,entity.getFuelType());
            prepStmt.setInt(12,entity.getDateOfCar());


            prepStmt.executeUpdate();

            prepStmt.close();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Car getSingleEntityById(int id) {

        List<Car> SingleEntityIdCar = new ArrayList<Car>();

        try {
            prepStmt = conn.prepareStatement("SELECT reg_number FROM db_bilabonnement.tbl_car");
            rs = prepStmt.executeQuery();

            while (rs.next()) {

                Car SingleEntityCarID = new Car(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getInt(6),
                rs.getInt(7),
                rs.getInt(8),
                rs.getInt(9),
                rs.getInt(10),
                rs.getString(11),
                rs.getInt(12));

                SingleEntityIdCar.add(SingleEntityCarID);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return (Car) SingleEntityIdCar;
    }

    @Override
    public List<Car> getAllEntities() {

        List<Car> allCarsEntities = new ArrayList<Car>();

        try {
            prepStmt = conn.prepareStatement("SELECT * FROM db_bilabonnement.tbl_car");
            rs = prepStmt.executeQuery();

            while (rs.next()) {

            Car allCars = new Car(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getInt(6),
                rs.getInt(7),
                rs.getInt(8),
                rs.getInt(9),
                rs.getInt(10),
                rs.getString(11),
                rs.getInt(12)
                );

            allCarsEntities.add(allCars);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allCarsEntities;
    }

    @Override
    public List<Car> getAllEntitiesById(int id) {

        List<Car> allEntitiesById = new ArrayList<Car>();

        try {
            prepStmt = conn.prepareStatement("SELECT * FROM db_bilabonnement.tbl_car WHERE reg_number");

            while (rs.next()) {
                Car AllEntitiesCar = new Car(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11),
                        rs.getInt(12));

                prepStmt.executeUpdate();

                allEntitiesById.add(AllEntitiesCar);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allEntitiesById;
    }

    @Override
    public boolean updateEntity(Car entity) {

        try {
            prepStmt = conn.prepareStatement("SELECT * FROM db_bilabonnement.tbl_car SET reg_number=?, car_brand=?, car_model=?, car_color=?, " +
                    "accessories_level=?, chasis_number=?, driven_km=?, tax=?, co2_emission=?, stel_price=?, fuel_type=?, date=?");

            prepStmt.setInt(1,entity.getRegNumber());
            prepStmt.setString(2,entity.getCarBrand());
            prepStmt.setString(3,entity.getCarModel());
            prepStmt.setString(4,entity.getCarColor());
            prepStmt.setString(5,entity.getAccessories());
            prepStmt.setInt(6,entity.getChasisLevel());
            prepStmt.setInt(7,entity.getDrivenKM());
            prepStmt.setInt(8,entity.getTax());
            prepStmt.setInt(9,entity.getCo2Emission());
            prepStmt.setInt(10,entity.getStelPrice());
            prepStmt.setString(11,entity.getFuelType());
            prepStmt.setInt(12,entity.getDateOfCar());


            prepStmt.executeUpdate();

            prepStmt.close();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteEntityById(int id) {
        try {
            prepStmt = conn.prepareStatement("DELETE  FROM db_bilabonnement.tbl_car WHERE reg_number=?");

            prepStmt.setInt(1,id);

            prepStmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
