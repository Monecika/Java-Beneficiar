package org.project.DAO.interfaces;

import org.project.DAO.CrudDAO;
import org.project.entity.Localities;

import java.sql.SQLException;

public interface LocalitiesDAO extends CrudDAO<Localities> {
    Localities getLocality(String name) throws SQLException;
}
