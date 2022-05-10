package com.kea.bilabonnement.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionHandler {

    private static String url;
    private static String username;
    private static String password;
    private static Connection conn;

    public DatabaseConnectionHandler() {
    }

    public static Connection getConnection(){
        if(conn != null){
            return conn;
        }

        try{
            //Environment Variables
            url = System.getenv("db.url");
            username = System.getenv("db.username");
            password = System.getenv("db.password");
            conn = DriverManager.getConnection(url, username, password);
        }

        catch(SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
}
