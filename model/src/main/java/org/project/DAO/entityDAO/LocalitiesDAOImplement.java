package org.project.DAO.entityDAO;

import org.project.ConfigLoader;
import org.project.DAO.interfaces.LocalitiesDAO;
import org.project.Database;
import org.project.entity.Localities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class LocalitiesDAOImplement implements LocalitiesDAO {
    private final static String SQL_SELECT_LOCALITIES = ConfigLoader.getProperty("sql.SQL_SELECT_LOCALITIES");
    private final static String SQL_SELECT_LOCALITY = ConfigLoader.getProperty("sql.SQL_SELECT_LOCALITY");
    private final static String SQL_INSERT_LOCALITY = ConfigLoader.getProperty("sql.SQL_INSERT_LOCALITY");
    private final static String SQL_UPDATE_LOCALITY = ConfigLoader.getProperty("sql.SQL_UPDATE_LOCALITY");
    private final static String SQL_DELETE_LOCALITY = ConfigLoader.getProperty("sql.SQL_DELETE_LOCALITY");


    @Override
    public List<Localities> getAll() throws SQLException {
        return List.of();
    }

    @Override
    public void create(Localities localities) throws SQLException {

    }

    @Override
    public void add(Localities localities) throws SQLException {

    }

    @Override
    public void update(Localities localities) throws SQLException {

    }

    @Override
    public void delete(Localities localities) throws SQLException {

    }

    @Override
    public Localities getObject(int id) throws SQLException {
        Connection connection = Database.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL_SELECT_LOCALITY);

        Localities localities = null;
        while(resultSet.next()) {
        }
        return null;
    }
}
