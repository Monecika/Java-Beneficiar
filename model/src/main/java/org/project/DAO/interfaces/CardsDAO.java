package org.project.DAO.interfaces;

import org.project.DAO.CrudDAO;
import org.project.Database;
import org.project.entity.Cards;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface CardsDAO extends CrudDAO<Cards> {
}
