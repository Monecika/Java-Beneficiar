package org.project.DAO.entityDAO;

import org.project.DAO.interfaces.EnvironmentsDAO;
import org.project.entity.Environments;

import java.sql.SQLException;
import java.util.List;

public class EnvironmentsDAOImplement implements EnvironmentsDAO {
    @Override
    public List<Environments> getAll() throws SQLException {
        return List.of();
    }

    @Override
    public void create(Environments environments) throws SQLException {

    }

    @Override
    public void add(Environments environments) throws SQLException {

    }

    @Override
    public void update(Environments environments) throws SQLException {

    }

    @Override
    public void delete(Environments environments) throws SQLException {

    }
}
