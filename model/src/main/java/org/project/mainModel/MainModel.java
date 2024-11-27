package org.project.mainModel;

import org.project.DAO.entityDAO.BeneficiariesDAOImplement;
import org.project.DAO.entityDAO.DisplayDataDAOImplement;
import org.project.DAO.entityDAO.ScepticDataDAOImplementation;
import org.project.Model;
import org.project.entity.Beneficiaries;
import org.project.entity.DisplayData;
import org.project.entity.ScepticData;

import java.sql.SQLException;
import java.util.List;

public class MainModel extends Model {
    private final DisplayDataDAOImplement displayDataDAOImplement;
    private final ScepticDataDAOImplementation scepticDataDAOImplementation;
    private final BeneficiariesDAOImplement beneficiariesDAOImplement;


    public MainModel() {
        displayDataDAOImplement = new DisplayDataDAOImplement();
        scepticDataDAOImplementation = new ScepticDataDAOImplementation();
        beneficiariesDAOImplement = new BeneficiariesDAOImplement();
    }

    public List<DisplayData> getDisplayData() throws SQLException {
        return displayDataDAOImplement.getAll();
    }

    public List<ScepticData> getScepticData() throws SQLException {
        return scepticDataDAOImplementation.getAll();
    }

    public void updateDisplayData(String[] data) throws SQLException {
        DisplayData displayData = new DisplayData(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8], data[9]);
        displayDataDAOImplement.update(displayData);
    }

    public void deleteBen(String number) throws SQLException {
        Beneficiaries beneficiaries = beneficiariesDAOImplement.getBeneficiary(number);
        beneficiariesDAOImplement.delete(beneficiaries);
    }


}
