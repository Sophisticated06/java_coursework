package com.example.journal.dao;

import com.example.journal.config.ConfigLoader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    
    // Получаем параметры из нашего внешнего файла конфигурации
    private static final String URL = ConfigLoader.getProperty("db.url");
    private static final String USER = ConfigLoader.getProperty("db.user");
    private static final String PASSWORD = ConfigLoader.getProperty("db.password");

    // Возвращает новое соединение с базой данных по параметрам из config.properties
    public static Connection getConnection() throws SQLException {
        if (URL == null) {
            throw new SQLException("URL базы данных не найден в конфигурационном файле!");
        }
        
        if (USER != null && PASSWORD != null) {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } else {
            return DriverManager.getConnection(URL);
        }
    }
}