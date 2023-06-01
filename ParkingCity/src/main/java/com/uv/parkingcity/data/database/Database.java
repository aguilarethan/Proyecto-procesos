package com.uv.parkingcity.data.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Database {

    public Connection getConnection() throws SQLException{

        Connection connection;
        final String DATABASE_NAME = "jdbc:mysql://127.0.0.1/parkingcity";
        final String DATABASE_USER = "Armando";
        final String DATABASE_PASSWORD = "123456";

        connection = DriverManager.getConnection(DATABASE_NAME, DATABASE_USER, DATABASE_PASSWORD);
        return connection;

    }

}
