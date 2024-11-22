package org.project.DAO.interfaces;

import org.project.DAO.CrudDAO;
import org.project.Database;
import org.project.entity.Environments;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface EnvironmentsDAO extends CrudDAO<Environments> {
}
