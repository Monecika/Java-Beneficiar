package org.project.DAO;

import java.sql.SQLException;
import java.util.List;

public interface CrudDAO<T>{
    List<T> getAll() throws SQLException;
    void create(T t) throws SQLException;
    void add(T t) throws SQLException;
    void update(T t) throws SQLException;
    void delete(T t) throws SQLException;
    T getObject(int id) throws  SQLException;
}
