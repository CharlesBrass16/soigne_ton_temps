package com.soigne_ton_temps.app.persistance.patient;

import com.soigne_ton_temps.app.persistance.SQLiteTableCreator;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PatientTableCreator implements SQLiteTableCreator {

    @Override
    public void createTableIfNotExist(Connection connection) {
        String createOrderTable =
                "CREATE TABLE IF NOT EXISTS PATIENTS ("
                        + "PatientID INTEGER PRIMARY KEY NOT NULL,"
                        + "Date DATE,"
                        + "ProblemDescription CHAR(128),"
                        + ");";

        try (Statement statement = connection.createStatement()) {
            statement.execute(createOrderTable);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

