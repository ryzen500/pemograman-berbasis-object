/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventoryproject.models.utils;

/**
 *
 * @author tsany
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public static class Connector {
        private static final String URL = "jdbc:mysql://localhost:3306/inventory";
        private static final String USER = "root";
        private static final String PASSWORD = "Shinigami_145";

        public static Connection connect() throws Exception {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }
    }
}
