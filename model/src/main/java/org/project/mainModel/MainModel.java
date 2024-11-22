package org.project.mainModel;

import org.project.ConfigLoader;
import org.project.DAO.entityDAO.BeneficiariesDAOImplement;
import org.project.DAO.entityDAO.DisplayDataDAOImplement;
import org.project.Model;
import org.project.entity.Beneficiaries;
import org.project.entity.DisplayData;

import java.sql.SQLException;
import java.util.List;

public class MainModel extends Model {
    private final DisplayDataDAOImplement displayDataDAOImplement;


    public MainModel() {
        displayDataDAOImplement = new DisplayDataDAOImplement();
    }

    public List<DisplayData> getDisplayData() throws SQLException {
        return displayDataDAOImplement.getAll();
    }


}
