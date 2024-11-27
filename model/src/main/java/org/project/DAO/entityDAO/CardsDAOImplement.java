package org.project.DAO.entityDAO;

import org.project.ConfigLoader;
import org.project.DAO.interfaces.CardsDAO;
import org.project.Database;
import org.project.entity.Cards;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CardsDAOImplement implements CardsDAO {
    private final static String SQL_SELECT_CARDS = ConfigLoader.getProperty("sql.SQL_SELECT_CARDS");
    private final static String SQL_SELECT_CARD = ConfigLoader.getProperty("sql.SQL_SELECT_CARD");
    private final static String SQL_SELECT_CARD_NUM = ConfigLoader.getProperty("sql.SQL_SELECT_CARD_NUM");
    private final static String SQL_INSERT_CARD = ConfigLoader.getProperty("sql.SQL_INSERT_CARD");
    private final static String SQL_UPDATE_CARD = ConfigLoader.getProperty("sql.SQL_UPDATE_CARD");
    private final static String SQL_DELETE_CARD = ConfigLoader.getProperty("sql.SQL_DELETE_CARD");

    @Override
    public List<Cards> getAll() throws SQLException {
        List<Cards> cardsList = new ArrayList<>();

        try (Connection connection = Database.getConnection(); PreparedStatement statement = connection.prepareStatement(SQL_SELECT_CARDS); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Cards card = extractCard(resultSet);
                cardsList.add(card);
            }
        }
        return cardsList;
    }

    @Override
    public Cards getObject(int id) throws SQLException {
        Cards card = null;

        try (Connection connection = Database.getConnection(); PreparedStatement statement = connection.prepareStatement(SQL_SELECT_CARD)) {

            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    card = extractCard(resultSet);
                }
            }
        }
        return card;
    }

    @Override
    public Cards getCard(String number) throws SQLException {
        Cards card = null;

        try (Connection connection = Database.getConnection(); PreparedStatement statement = connection.prepareStatement(SQL_SELECT_CARD_NUM)) {

            statement.setString(1, number);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    card = extractCard(resultSet);
                }
            }
        }
        return card;
    }

    @Override
    public void add(Cards card) throws SQLException {
        try (Connection connection = Database.getConnection(); PreparedStatement statement = connection.prepareStatement(SQL_INSERT_CARD)) {

            prepareStatement(statement, card);
            statement.executeUpdate();
        }
    }

    @Override
    public void update(Cards card) throws SQLException {
        try (Connection connection = Database.getConnection(); PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_CARD)) {

            prepareStatement(statement, card);
            statement.setInt(4, card.getID());
            statement.executeUpdate();
        }
    }

    @Override
    public void delete(Cards card) throws SQLException {
        try (Connection connection = Database.getConnection(); PreparedStatement statement = connection.prepareStatement(SQL_DELETE_CARD)) {

            statement.setInt(1, card.getID());
            statement.executeUpdate();
        }
    }

    private Cards extractCard(ResultSet resultSet) throws SQLException {
        return new Cards(resultSet.getInt("id"), resultSet.getString("cardNr"), resultSet.getString("cardType"), resultSet.getDate("dateExpire"));
    }

    private void prepareStatement(PreparedStatement statement, Cards card) throws SQLException {
        statement.setString(1, card.getCardNr());
        statement.setString(2, card.getCardType());
        statement.setDate(3, new java.sql.Date(card.getDateExpire().getTime()));
    }
}
