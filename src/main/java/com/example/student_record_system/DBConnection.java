package com.example.student_record_system;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static String host = System.getenv().getOrDefault("DB_HOST", "localhost");
    public static String port = System.getenv().getOrDefault("DB_PORT", "3306");
    public static String database = System.getenv().getOrDefault("DB_NAME", "studentdb");
    public static String user = System.getenv().getOrDefault("DB_USER", "root");
    public static String password = System.getenv().getOrDefault("DB_PASSWORD", "Kgkite@123");

    public static String URL = "jdbc:mysql://" + host + ":" + port + "/" + database;
    

    public static Connection getConnection() {

        try {

            return DriverManager.getConnection(
                    URL,
                    user,
                    password
            );

        } catch (Exception e) {

            e.printStackTrace();

            return null;

        }

    }

}