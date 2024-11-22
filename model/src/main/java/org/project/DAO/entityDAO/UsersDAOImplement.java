package org.project.DAO.entityDAO;

import org.project.ConfigLoader;
import org.project.DAO.interfaces.UsersDAO;
import org.project.Database;
import org.project.entity.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersDAOImplement implements UsersDAO {

    private static final String SQL_SELECT_ALL = ConfigLoader.getProperty("sql.SQL_SELECT_USERS");
    private static final String SQL_SELECT_BY_ID = ConfigLoader.getProperty("sql.SQL_SELECT_USER");
    private static final String SQL_INSERT = ConfigLoader.getProperty("sql.SQL_INSERT_USER");
    private static final String SQL_UPDATE = ConfigLoader.getProperty("sql.SQL_UPDATE_USER");
    private static final String SQL_DELETE = ConfigLoader.getProperty("sql.SQL_DELETE_USER");

    @Override
    public List<Users> getAll() throws SQLException {
        List<Users> usersList = new ArrayList<>();

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Users user = extractUser(resultSet);
                usersList.add(user);
            }
        }
        return usersList;
    }

    @Override
    public void add(Users user) throws SQLException {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_INSERT)) {

            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setDate(3, new java.sql.Date(user.getCreatedAt().getTime()));
            statement.setInt(4, user.getRoleID());
            statement.executeUpdate();
        }
    }

    @Override
    public void update(Users user) throws SQLException {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE)) {

            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setDate(3, new java.sql.Date(user.getCreatedAt().getTime()));
            statement.setInt(4, user.getRoleID());
            statement.setInt(5, user.getID());
            statement.executeUpdate();
        }
    }

    @Override
    public void delete(Users user) throws SQLException {
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_DELETE)) {

            statement.setInt(1, user.getID());
            statement.executeUpdate();
        }
    }

    @Override
    public Users getObject(int id) throws SQLException {
        Users user = null;

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_ID)) {

            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    user = extractUser(resultSet);
                }
            }
        }
        return user;
    }

    private Users extractUser(ResultSet resultSet) throws SQLException {
        return new Users(
                resultSet.getInt("id"),
                resultSet.getString("username"),
                resultSet.getString("password"),
                resultSet.getDate("createdat"),
                resultSet.getInt("roleid")
        );
    }
}
