package org.project.DAO.entityDAO;

import org.project.ConfigLoader;
import org.project.DAO.interfaces.EnvironmentsDAO;
import org.project.Database;
import org.project.entity.Environments;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnvironmentsDAOImplement implements EnvironmentsDAO {
    private final static String SQL_SELECT = ConfigLoader.getProperty("sql.SQL_SELECT_ENVIRONMENTS");
    private final static String SQL_SELECT_ENV = ConfigLoader.getProperty("sql.SQL_SELECT_ENVIRONMENT");
    private final static String SQL_INSERT = ConfigLoader.getProperty("sql.SQL_INSERT_ENVIRONMENT");
    private final static String SQL_UPDATE = ConfigLoader.getProperty("sql.SQL_UPDATE_ENVIRONMENT");
    private final static String SQL_DELETE = ConfigLoader.getProperty("sql.SQL_DELETE_ENVIRONMENT");

    @Override
    public List<Environments> getAll() throws SQLException {
        List<Environments> environmentsList = new ArrayList<>();
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Environments environment = extractEnvironment(resultSet);
                environmentsList.add(environment);
            }
        }
        return environmentsList;
    }

    @Override
    public void add(Environments environments) throws SQLException {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_INSERT)) {

            prepareStatement(statement, environments);
            statement.executeUpdate();
        }
    }

    @Override
    public void update(Environments environments) throws SQLException {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE)) {

            prepareStatement(statement, environments);
            statement.setInt(3, environments.getID());
            statement.executeUpdate();
        }
    }

    @Override
    public void delete(Environments environments) throws SQLException {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_DELETE)) {

            statement.setInt(1, environments.getID());
            statement.executeUpdate();
        }
    }

    @Override
    public Environments getObject(int id) throws SQLException {
        Environments environment = null;
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ENV)) {

            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    environment = extractEnvironment(resultSet);
                }
            }
        }
        return environment;
    }

    private Environments extractEnvironment(ResultSet resultSet) throws SQLException {
        return new Environments(
                resultSet.getInt("id"),
                resultSet.getString("environmenttype"),
                resultSet.getInt("popularitypercentage")
        );
    }

    private void prepareStatement(PreparedStatement statement, Environments environments) throws SQLException {
        statement.setString(1, environments.getEnvironment());
        statement.setInt(2, environments.getPopularityPercentage());
    }
}
