package com.soigne_ton_temps.app.persistance;

import java.sql.Connection;

public interface SQLiteTableCreator {

    void createTableIfNotExist(Connection connection);
}
