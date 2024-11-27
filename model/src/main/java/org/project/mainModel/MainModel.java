package org.project.mainModel;

import org.project.DAO.entityDAO.*;
import org.project.Model;
import org.project.entity.*;

import java.sql.SQLException;
import java.util.List;

public class MainModel extends Model {
    private final DisplayDataDAOImplement displayDataDAOImplement;
    private final ScepticDataDAOImplementation scepticDataDAOImplementation;

    private final BeneficiariesDAOImplement beneficiariesDAOImplement;
    private final EnvironmentsDAOImplement environmentsDAOImplement;
    private final LocalitiesDAOImplement localitiesDAOImplement;
    private final CardsDAOImplement cardsDAOImplement;

    public MainModel() {
        displayDataDAOImplement = new DisplayDataDAOImplement();
        scepticDataDAOImplementation = new ScepticDataDAOImplementation();

        beneficiariesDAOImplement = new BeneficiariesDAOImplement();
        environmentsDAOImplement = new EnvironmentsDAOImplement();
        localitiesDAOImplement = new LocalitiesDAOImplement();
        cardsDAOImplement = new CardsDAOImplement();
    }

    public List<DisplayData> getDisplayData() {
        try {
            return displayDataDAOImplement.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ScepticData> getScepticData() {
        try {
            return scepticDataDAOImplementation.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Environments> getEnvironment() {
        try {
            return environmentsDAOImplement.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Localities> getLocality() {
        try {
            return localitiesDAOImplement.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cards> getCard() {
        try {
            return cardsDAOImplement.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addData(DisplayData displayData) {
        try {
            displayDataDAOImplement.add(displayData);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateDisplayData(String[] data) {
        DisplayData displayData = new DisplayData(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8], data[9]);
        try {
            displayDataDAOImplement.update(displayData);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteBen(String number) {
        Beneficiaries beneficiaries;

        try {
            beneficiaries = beneficiariesDAOImplement.getBeneficiary(number);

            beneficiariesDAOImplement.delete(beneficiaries);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
