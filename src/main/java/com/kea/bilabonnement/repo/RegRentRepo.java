package com.kea.bilabonnement.repo;

import com.kea.bilabonnement.model.RegRent;
import com.kea.bilabonnement.utility.DatabaseConnectionHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RegRentRepo implements BilabonnementCRUD<RegRent> {

    Connection conn = DatabaseConnectionHandler.getConnection();
    PreparedStatement prepStmt;
    ResultSet rs;


    @Override
    public boolean addEntity(RegRent entity) {

        try{
            prepStmt = conn.prepareStatement("INSERT INTO ");

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public RegRent getSingleEntityById(int id) {
        return null;
    }

    @Override
    public List<RegRent> getAllEntities() {
        return null;
    }

    @Override
    public List<RegRent> getAllEntitiesById(int id) {
        return null;
    }

    @Override
    public boolean updateEntity(RegRent entity) {
        return false;
    }

    @Override
    public boolean deleteEntityById(int id) {
        return false;
    }
}
