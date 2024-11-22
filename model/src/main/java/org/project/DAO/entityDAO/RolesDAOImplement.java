package org.project.DAO.entityDAO;

import org.project.DAO.interfaces.RolesDAO;
import org.project.entity.Roles;

import java.sql.SQLException;
import java.util.List;

public class RolesDAOImplement implements RolesDAO {
    @Override
    public List<Roles> getAll() throws SQLException {
        return List.of();
    }

    @Override
    public void create(Roles roles) throws SQLException {

    }

    @Override
    public void add(Roles roles) throws SQLException {

    }

    @Override
    public void update(Roles roles) throws SQLException {

    }

    @Override
    public void delete(Roles roles) throws SQLException {

    }

    @Override
    public Roles getObject(int id) throws SQLException {
        return null;
    }
}
