package org.project.DAO.entityDAO;

import org.project.ConfigLoader;
import org.project.DAO.interfaces.RolesDAO;
import org.project.Database;
import org.project.entity.Roles;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RolesDAOImplement implements RolesDAO {

    private static final String SQL_SELECT_ALL = ConfigLoader.getProperty("sql.SQL_SELECT_ROLES");
    private static final String SQL_SELECT_BY_ID = ConfigLoader.getProperty("sql.SQL_SELECT_ROLE");
    private static final String SQL_INSERT = ConfigLoader.getProperty("sql.SQL_INSERT_ROLE");
    private static final String SQL_UPDATE = ConfigLoader.getProperty("sql.SQL_UPDATE_ROLE");
    private static final String SQL_DELETE = ConfigLoader.getProperty("sql.SQL_DELETE_ROLE");

    @Override
    public List<Roles> getAll() throws SQLException {
        List<Roles> rolesList = new ArrayList<>();

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Roles role = extractRole(resultSet);
                rolesList.add(role);
            }
        }

        return rolesList;
    }

    @Override
    public void add(Roles role) throws SQLException {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_INSERT)) {

            statement.setString(1, role.getRole());
            statement.executeUpdate();
        }
    }

    @Override
    public void update(Roles role) throws SQLException {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE)) {

            statement.setString(1, role.getRole());
            statement.setInt(2, role.getID());
            statement.executeUpdate();
        }
    }

    @Override
    public void delete(Roles role) throws SQLException {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_DELETE)) {

            statement.setInt(1, role.getID());
            statement.executeUpdate();
        }
    }

    @Override
    public Roles getObject(int id) throws SQLException {
        Roles role = null;

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_ID)) {

            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    role = extractRole(resultSet);
                }
            }
        }

        return role;
    }

    private Roles extractRole(ResultSet resultSet) throws SQLException {
        return new Roles(
                resultSet.getInt("id"),
                resultSet.getString("rolename")
        );
    }
}
