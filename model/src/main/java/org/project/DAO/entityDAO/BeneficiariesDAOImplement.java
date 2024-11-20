package org.project.DAO.entityDAO;

import org.project.ConfigLoader;
import org.project.DAO.interfaces.BeneficiariesDAO;
import org.project.Database;
import org.project.entity.Beneficiaries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BeneficiariesDAOImplement implements BeneficiariesDAO {
    private final static String SQL_SELECT = ConfigLoader.getProperty("SQL_SELECT_BENEFICIARIES");
    private final static String SQL_INSERT = ConfigLoader.getProperty("SQL_INSERT_BENEFICIARIES");
    private final static String SQL_UPDATE = ConfigLoader.getProperty("SQL_UPDATE_BENEFICIARIES");
    private final static String SQL_DELETE = ConfigLoader.getProperty("SQL_DELETE_BENEFICIARIES");

    public BeneficiariesDAOImplement() {
    }

    @Override
    public List<Beneficiaries> getAll() throws SQLException {
        Connection connection = Database.getConnection();
        List<Beneficiaries> beneficiariesList = new ArrayList<>();

        PreparedStatement statement = connection.prepareStatement(SQL_SELECT);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String benID = resultSet.getString("nrben");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            String phone = resultSet.getString("phone");
            String idnp = resultSet.getString("idnp");
            String address = resultSet.getString("address");
            String email = resultSet.getString("email");
            int localityID = resultSet.getInt("localityid");
            String environment = resultSet.getString("environment");
            int cardID = resultSet.getInt("cardid");

            Beneficiaries ben = new Beneficiaries(id, benID, name, surname, phone, idnp, address, email, localityID, environment, cardID);
            beneficiariesList.add(ben);
        }

        return beneficiariesList;
    }

    @Override
    public void create(Beneficiaries beneficiaries) throws SQLException {

    }

    @Override
    public void add(Beneficiaries beneficiaries) throws SQLException {

    }

    @Override
    public void update(Beneficiaries beneficiaries) throws SQLException {

    }

    @Override
    public void delete(Beneficiaries beneficiaries) throws SQLException {

    }
}
