package org.project.DAO.entityDAO;

import org.project.DAO.interfaces.BeneficiariesDAO;
import org.project.entity.Beneficiaries;

import java.sql.SQLException;
import java.util.List;

public class BeneficiariesDAOImplement implements BeneficiariesDAO {
    @Override
    public List<Beneficiaries> getAll() throws SQLException {
        return List.of();
    }

    @Override
    public void create(Beneficiaries beneficiaries) throws SQLException {

    }

    @Override
    public void add(Beneficiaries beneficiaries) throws SQLException {

    }

    @Override
    public void update(Beneficiaries beneficiaries) throws SQLException {

    }

    @Override
    public void delete(Beneficiaries beneficiaries) throws SQLException {

    }
}
