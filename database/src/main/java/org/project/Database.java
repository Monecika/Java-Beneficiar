package org.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final ConfigLoader config = new ConfigLoader();

    private static final String URL = config.getProperty("db.url");
    private static final String USERNAME = config.getProperty("db.user");
    private static final String PASSWORD = config.getProperty("db.password");

    public Database() {
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        return connection;
    }
}
