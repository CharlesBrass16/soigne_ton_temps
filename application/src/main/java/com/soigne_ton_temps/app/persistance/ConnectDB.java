package com.soigne_ton_temps.app.persistance;

import com.soigne_ton_temps.app.persistance.patient.PatientTableCreator;
import jakarta.inject.Inject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectDB {
    private Connection connection;
    private final DatabaseConfig databaseConfig;
    private final List<SQLiteTableCreator> tableCreators;
    private final Logger logger = LoggerFactory.getLogger(ConnectDB.class);

    @Inject
    public ConnectDB() {
        this.tableCreators =
                Arrays.asList(
                        new PatientTableCreator());

        if (persistenceIsSqlite()) {
            databaseConfig = new SQLiteConfig();
        } else {
            databaseConfig = new SQLiteConfig();
        }

        try {
            String databaseUrl = databaseConfig.getDatabaseUrlPath();
            connection = DriverManager.getConnection(databaseUrl);
            createTablesIfNotExist();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }

    public Connection getConnection() {
        try {
            if (connection.isClosed()) {
                String databaseUrl = databaseConfig.getDatabaseUrlPath();
                connection = DriverManager.getConnection(databaseUrl);
                return connection;
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }

    private void createTablesIfNotExist() {
        for (SQLiteTableCreator creator : tableCreators) {
            creator.createTableIfNotExist(connection);
        }
    }

    private boolean persistenceIsSqlite() {
        return (Objects.equals(System.getProperty("persistence"), "sqlite"));
    }
}
