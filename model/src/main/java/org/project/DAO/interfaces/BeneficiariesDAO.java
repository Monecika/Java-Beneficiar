package org.project.DAO.interfaces;

import org.project.DAO.CrudDAO;
import org.project.Database;
import org.project.entity.Beneficiaries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public interface BeneficiariesDAO extends CrudDAO<Beneficiaries> {
}
