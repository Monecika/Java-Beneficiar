package org.project.mainModel;

import org.project.ConfigLoader;
import org.project.DAO.entityDAO.BeneficiariesDAOImplement;
import org.project.Model;
import org.project.entity.Beneficiaries;

import java.sql.SQLException;
import java.util.List;

public class MainModel extends Model {
    private final BeneficiariesDAOImplement beneficiariesDAOImplement;


    public MainModel() {
        beneficiariesDAOImplement = new BeneficiariesDAOImplement();
    }

    public List<Beneficiaries> getBeneficiaries() throws SQLException {
        return beneficiariesDAOImplement.getAll();
    }


}
