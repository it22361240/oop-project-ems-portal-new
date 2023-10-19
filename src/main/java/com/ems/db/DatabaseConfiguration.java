package com.ems.db;

import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;

public class DatabaseConfiguration {
    private Properties properties;

    public DatabaseConfiguration() {
        properties = new Properties();
        try (InputStream inputStream = getClass().getResourceAsStream("/database.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception
        }
    }

    public String getDatabaseURL() {
        return properties.getProperty("db.url");
    }

    public String getDatabaseUsername() {
        return properties.getProperty("db.username");
    }

    public String getDatabasePassword() {
        return properties.getProperty("db.password");
    }
}
