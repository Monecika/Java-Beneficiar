package org.project.DAO.interfaces;

import org.project.DAO.CrudDAO;
import org.project.entity.Cards;

import java.sql.SQLException;

public interface CardsDAO extends CrudDAO<Cards> {
    Cards getCard(String number) throws SQLException;
}
