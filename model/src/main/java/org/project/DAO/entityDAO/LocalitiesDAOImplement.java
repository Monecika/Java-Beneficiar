package org.project.DAO.entityDAO;

import org.project.ConfigLoader;
import org.project.DAO.interfaces.LocalitiesDAO;
import org.project.Database;
import org.project.entity.Localities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocalitiesDAOImplement implements LocalitiesDAO {
    private final static String SQL_SELECT_LOCALITIES = ConfigLoader.getProperty("sql.SQL_SELECT_LOCALITIES");
    private final static String SQL_SELECT_LOCALITY = ConfigLoader.getProperty("sql.SQL_SELECT_LOCALITY");
    private final static String SQL_SELECT_LOCALITY_NAME = ConfigLoader.getProperty("sql.SQL_SELECT_LOCALITY_NAME");
    private final static String SQL_INSERT_LOCALITY = ConfigLoader.getProperty("sql.SQL_INSERT_LOCALITY");
    private final static String SQL_UPDATE_LOCALITY = ConfigLoader.getProperty("sql.SQL_UPDATE_LOCALITY");
    private final static String SQL_DELETE_LOCALITY = ConfigLoader.getProperty("sql.SQL_DELETE_LOCALITY");

    @Override
    public List<Localities> getAll() throws SQLException {
        List<Localities> localitiesList = new ArrayList<>();
        try (Connection connection = Database.getConnection(); PreparedStatement statement = connection.prepareStatement(SQL_SELECT_LOCALITIES); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Localities localities = extractLocality(resultSet);
                localitiesList.add(localities);
            }
        }
        return localitiesList;
    }

    @Override
    public void add(Localities localities) throws SQLException {
        try (Connection connection = Database.getConnection(); PreparedStatement statement = connection.prepareStatement(SQL_INSERT_LOCALITY)) {

            prepareStatement(statement, localities);
            statement.executeUpdate();
        }
    }

    @Override
    public void update(Localities localities) throws SQLException {
        try (Connection connection = Database.getConnection(); PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_LOCALITY)) {

            prepareStatement(statement, localities);
            statement.setInt(6, localities.getID());
            statement.executeUpdate();
        }
    }

    @Override
    public void delete(Localities localities) throws SQLException {
        try (Connection connection = Database.getConnection(); PreparedStatement statement = connection.prepareStatement(SQL_DELETE_LOCALITY)) {

            statement.setInt(1, localities.getID());
            statement.executeUpdate();
        }
    }

    @Override
    public Localities getObject(int id) throws SQLException {
        Localities localities = null;
        try (Connection connection = Database.getConnection(); PreparedStatement statement = connection.prepareStatement(SQL_SELECT_LOCALITY)) {

            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    localities = extractLocality(resultSet);
                }
            }
        }
        return localities;
    }

    @Override
    public Localities getLocality(String name) throws SQLException {
        Localities localities = null;
        try (Connection connection = Database.getConnection(); PreparedStatement statement = connection.prepareStatement(SQL_SELECT_LOCALITY_NAME)) {

            statement.setString(1, name);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    localities = extractLocality(resultSet);
                }
            }
        }
        return localities;
    }

    private Localities extractLocality(ResultSet resultSet) throws SQLException {
        return new Localities(resultSet.getInt("id"), resultSet.getString("localityName"), resultSet.getString("localityType"), resultSet.getInt("environmentID"), resultSet.getInt("population"), resultSet.getDouble("area"));
    }

    private void prepareStatement(PreparedStatement statement, Localities localities) throws SQLException {
        statement.setString(1, localities.getLocalityName());
        statement.setString(2, localities.getLocalityType());
        statement.setInt(3, localities.getEnvironmentID());
        statement.setInt(4, localities.getPopulation());
        statement.setDouble(5, localities.getArea());
    }
}
