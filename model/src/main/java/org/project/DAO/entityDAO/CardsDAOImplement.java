package org.project.DAO.entityDAO;

import org.project.DAO.interfaces.CardsDAO;
import org.project.entity.Cards;

import java.sql.SQLException;
import java.util.List;

public class CardsDAOImplement implements CardsDAO {
    @Override
    public List<Cards> getAll() throws SQLException {
        return List.of();
    }

    @Override
    public void create(Cards cards) throws SQLException {

    }

    @Override
    public void add(Cards cards) throws SQLException {

    }

    @Override
    public void update(Cards cards) throws SQLException {

    }

    @Override
    public void delete(Cards cards) throws SQLException {

    }
}
