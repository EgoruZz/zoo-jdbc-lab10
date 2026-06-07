package com.zoo.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.util.Properties;

public class ConnectionManager {

    private static final HikariDataSource dataSource;

    static {
        try {
            Properties props = new Properties();
            props.load(ConnectionManager.class.getClassLoader()
                    .getResourceAsStream("application.properties"));

            HikariConfig config = new HikariConfig();

            config.setJdbcUrl(props.getProperty("db.url"));
            config.setUsername(props.getProperty("db.user"));
            config.setPassword(props.getProperty("db.password"));

            config.setMaximumPoolSize(10);

            dataSource = new HikariDataSource(config);

        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize DataSource", e);
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    public static void shutdown() {
        if (dataSource != null) {
            dataSource.close();
        }
    }
}