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
    private final static String SQL_SELECT = ConfigLoader.getProperty("sql.SQL_SELECT_BENEFICIARIES");
    private final static String SQL_SELECT_BEN = ConfigLoader.getProperty("sql.SQL_SELECT_BENEFICIARY");
    private final static String SQL_SELECT_BEN_NUM = ConfigLoader.getProperty("sql.SQL_SELECT_BENEFICIARY_NUM");
    private final static String SQL_INSERT = ConfigLoader.getProperty("sql.SQL_INSERT_BENEFICIARIES");
    private final static String SQL_UPDATE = ConfigLoader.getProperty("sql.SQL_UPDATE_BENEFICIARIES");
    private final static String SQL_DELETE = ConfigLoader.getProperty("sql.SQL_DELETE_BENEFICIARIES");

    @Override
    public List<Beneficiaries> getAll() throws SQLException {
        List<Beneficiaries> beneficiariesList = new ArrayList<>();

        try (Connection connection = Database.getConnection(); PreparedStatement statement = connection.prepareStatement(SQL_SELECT); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Beneficiaries beneficiary = extractBeneficiary(resultSet);
                beneficiariesList.add(beneficiary);
            }
        }
        return beneficiariesList;
    }

    @Override
    public Beneficiaries getObject(int id) throws SQLException {
        Beneficiaries beneficiary = null;

        try (Connection connection = Database.getConnection(); PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BEN)) {

            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    beneficiary = extractBeneficiary(resultSet);
                }
            }
        }
        return beneficiary;
    }

    @Override
    public Beneficiaries getBeneficiary(String number) throws SQLException {
        Beneficiaries beneficiary = null;

        try (Connection connection = Database.getConnection(); PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BEN_NUM)) {

            statement.setString(1, number);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    beneficiary = extractBeneficiary(resultSet);
                }
            }
            return beneficiary;
        }
    }

    @Override
    public void add(Beneficiaries beneficiary) throws SQLException {
        try (Connection connection = Database.getConnection(); PreparedStatement statement = connection.prepareStatement(SQL_INSERT)) {

            prepareStatement(statement, beneficiary);
            statement.executeUpdate();
        }
    }

    @Override
    public void update(Beneficiaries beneficiary) throws SQLException {
        try (Connection connection = Database.getConnection(); PreparedStatement statement = connection.prepareStatement(SQL_UPDATE)) {

            prepareStatement(statement, beneficiary);
            statement.setInt(11, beneficiary.getID());
            statement.executeUpdate();
        }
    }

    @Override
    public void delete(Beneficiaries beneficiary) throws SQLException {
        try (Connection connection = Database.getConnection(); PreparedStatement statement = connection.prepareStatement(SQL_DELETE)) {

            statement.setInt(1, beneficiary.getID());
            statement.executeUpdate();
        }
    }

    private Beneficiaries extractBeneficiary(ResultSet resultSet) throws SQLException {
        return new Beneficiaries(resultSet.getInt("id"), resultSet.getString("nrben"), resultSet.getString("name"), resultSet.getString("surname"), resultSet.getString("phone"), resultSet.getString("idnp"), resultSet.getString("address"), resultSet.getString("email"), resultSet.getInt("localityid"), resultSet.getString("environment"), resultSet.getInt("cardid"));
    }

    private void prepareStatement(PreparedStatement statement, Beneficiaries beneficiary) throws SQLException {
        statement.setString(1, beneficiary.getCodeBen());
        statement.setString(2, beneficiary.getNameBen());
        statement.setString(3, beneficiary.getSurnameBen());
        statement.setString(4, beneficiary.getPhoneBen());
        statement.setString(5, beneficiary.getIDNP());
        statement.setString(6, beneficiary.getAddressBen());
        statement.setString(7, beneficiary.getEmailBen());
        statement.setInt(8, beneficiary.getLocalityID());
        statement.setString(9, beneficiary.getEnvironment());
        statement.setInt(10, beneficiary.getCardID());
    }
}
