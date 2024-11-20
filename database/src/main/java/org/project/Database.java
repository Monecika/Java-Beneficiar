package org.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
//    private static final String URL = ConfigLoader.getProperty("db.url");
//    private static final String USERNAME = ConfigLoader.getProperty("db.user");
//    private static final String PASSWORD = ConfigLoader.getProperty("db.password");

    private static final String URL = "jdbc:postgresql://localhost:5432/Beneficiari";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "mona";


    public Database() {
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        return connection;
    }
}
