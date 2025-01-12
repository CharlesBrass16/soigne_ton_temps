package com.soigne_ton_temps.app.persistance;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public record SQLiteConfig() implements DatabaseConfig {
    private static final String DATABASE_NAME = "AppSqliteDatabase.db";
    private static final String DATABASE_PATH = "./sqlitedatabase/";

    private static final Logger logger = LoggerFactory.getLogger(ConnectDB.class);

    public String getDatabaseUrlPath() {
        File databaseFolder = new File(DATABASE_PATH);
        try {
            databaseFolder.mkdirs();
            return "jdbc:sqlite:" + Path.of("./" + DATABASE_PATH).toRealPath().resolve(DATABASE_NAME);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return "";
    }
}
