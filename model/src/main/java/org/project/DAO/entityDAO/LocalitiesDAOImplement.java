package org.project.DAO.entityDAO;

import org.project.DAO.interfaces.LocalitiesDAO;
import org.project.entity.Localities;

import java.sql.SQLException;
import java.util.List;

public class LocalitiesDAOImplement implements LocalitiesDAO {
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
}
