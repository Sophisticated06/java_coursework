package com.example.journal.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private static final Properties properties = new Properties();

    // Статический блок инициализации: загружает файл один раз при старте класса
    static {
        // Ищем файл config.properties в папке ресурсов (resources)
        try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Внимание: Не удалось найти файл config.properties! Будут использованы настройки по умолчанию.");
            } else {
                properties.load(input);
            }
        } catch (IOException ex) {
            System.err.println("Ошибка при чтении файла конфигурации: " + ex.getMessage());
        }
    }

    /**
     * Универсальный метод для получения настройки по ее ключу
     */
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    /**
     * Специальный метод для получения URL базы данных
     */
    public static String getDatabaseUrl() {
        // Если файл не нашелся, возвращаем стандартный путь к SQLite по умолчанию
        return properties.getProperty("db.url", "jdbc:sqlite:journal.db");
    }
}