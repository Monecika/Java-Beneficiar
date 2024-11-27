package org.project.mainModel;

import org.project.DAO.entityDAO.*;
import org.project.Model;
import org.project.entity.*;

import javax.smartcardio.Card;
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

    public List<Environments> getEnvironment() throws SQLException {
        return environmentsDAOImplement.getAll();
    }

    public List<Localities> getLocality() throws SQLException {
        return localitiesDAOImplement.getAll();
    }

    public List<Cards> getCard() throws SQLException {
        return cardsDAOImplement.getAll();
    }

    public void addData(DisplayData displayData) throws SQLException {
        displayDataDAOImplement.add(displayData);
    }


}
