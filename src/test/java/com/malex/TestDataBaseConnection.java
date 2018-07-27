package com.malex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDataBaseConnection
{
    /**
     * Database credentials
     */
    private static final String DB_URL = "jdbc:postgresql://0.0.0.0:5432/postgres";
    private static final String USER = "malexj";
    private static final String PASS = "2687484a";

    public static void main(String[] args)
    {
        System.out.println("Testing connection to PostgreSQL JDBC");

        try
        {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e)
        {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
            return;
        }

        System.out.println("PostgreSQL JDBC Driver successfully connected");
        Connection connection;
        try
        {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e)
        {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }
        if (connection != null)
        {
            System.out.println("You successfully connected to database now");
        } else
        {
            System.out.println("Failed to make connection to database");
        }
    }
}
