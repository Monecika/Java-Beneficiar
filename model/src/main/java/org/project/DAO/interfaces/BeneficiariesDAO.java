package org.project.DAO.interfaces;

import org.project.DAO.CrudDAO;
import org.project.entity.Beneficiaries;

import java.sql.SQLException;

public interface BeneficiariesDAO extends CrudDAO<Beneficiaries> {
    Beneficiaries getBeneficiary(String number) throws SQLException;
}
