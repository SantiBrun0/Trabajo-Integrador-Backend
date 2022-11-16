package com.santiagobruno.trabajointegrador.repository;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Helper {

    private final static String DB_URL = "jdbc:h2:~/test;INIT=RUNSCRIPT FROM 'create.sql'";
    private final static String DB_USER = "santi";
    private final static String DB_PASSWORD = "santi";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

}
