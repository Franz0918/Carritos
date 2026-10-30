package com.candens.carros2.Library.Util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoaderSql {
    private static final Properties properties = new Properties();

    static {
        // Carga el archivo desde resources en Java 8
        try (InputStream input = ConfigLoaderSql.class.getClassLoader().getResourceAsStream("consultas.properties")) {
            if (input == null) {
                System.out.println("No se pudo encontrar el archivo consultas.properties");
            } else {
                properties.load(input);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}