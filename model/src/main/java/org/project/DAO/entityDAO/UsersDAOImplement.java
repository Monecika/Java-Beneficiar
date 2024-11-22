package org.project.DAO.entityDAO;

import org.project.DAO.interfaces.UsersDAO;
import org.project.entity.Users;

import java.sql.SQLException;
import java.util.List;

public class UsersDAOImplement implements UsersDAO {
    @Override
    public List<Users> getAll() throws SQLException {
        return List.of();
    }

    @Override
    public void create(Users users) throws SQLException {

    }

    @Override
    public void add(Users users) throws SQLException {

    }

    @Override
    public void update(Users users) throws SQLException {

    }

    @Override
    public void delete(Users users) throws SQLException {

    }

    @Override
    public Users getObject(int id) throws SQLException {
        return null;
    }
}
