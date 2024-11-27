package org.project.DAO.entityDAO;

import org.project.DAO.CrudDAO;
import org.project.Database;
import org.project.entity.Beneficiaries;
import org.project.entity.Cards;
import org.project.entity.DisplayData;
import org.project.entity.Localities;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DisplayDataDAOImplement implements CrudDAO<DisplayData> {
    private final BeneficiariesDAOImplement beneficiariesDAO;
    private final CardsDAOImplement cardsDAO;
    private final LocalitiesDAOImplement localitiesDAO;

    public DisplayDataDAOImplement() {
        this.beneficiariesDAO = new BeneficiariesDAOImplement();
        this.cardsDAO = new CardsDAOImplement();
        this.localitiesDAO = new LocalitiesDAOImplement();
    }

    @Override
    public List<DisplayData> getAll() throws SQLException {
        List<DisplayData> displayDataList = new ArrayList<>();
        List<Beneficiaries> beneficiariesList = beneficiariesDAO.getAll();
        List<Cards> cardsList = cardsDAO.getAll();
        List<Localities> localitiesList = localitiesDAO.getAll();

        DisplayData displayData = null;
        Beneficiaries beneficiaries = null;
        Localities localities = null;
        Cards cards = null;

        while (beneficiariesList.size() > 0) {
            beneficiaries = beneficiariesList.get(0);
            int id = beneficiaries.getID();
            String benID = beneficiaries.getCodeBen();
            String name = beneficiaries.getNameBen();
            String surname = beneficiaries.getSurnameBen();
            String phone = beneficiaries.getPhoneBen();
            String idnp = beneficiaries.getIDNP();
            String address = beneficiaries.getAddressBen();
            String email = beneficiaries.getEmailBen();
            int localityID = beneficiaries.getLocalityID();
            String environment = beneficiaries.getEnvironment();
            int CardID = beneficiaries.getCardID();

            cards = cardsDAO.getObject(CardID);
            localities = localitiesDAO.getObject(localityID);

            beneficiariesList.remove(beneficiaries);

            displayData = new DisplayData(id, benID, name, surname, phone, idnp, address, email, localityID, localities.getLocalityName(), environment, CardID, cards.getCardNr());
            displayDataList.add(displayData);
        }

        return displayDataList;
    }


    @Override
    public void add(DisplayData displayData) throws SQLException {

    }

    @Override
    public void update(DisplayData displayData) throws SQLException {
        Beneficiaries beneficiary = beneficiariesDAO.getBeneficiary(displayData.getCodeBen());
        Localities locality = localitiesDAO.getLocality(displayData.getLocalityName());
        Cards card = cardsDAO.getCard(displayData.getCardNumber());

        beneficiary.setNameBen(displayData.getNameBen());
        beneficiary.setSurnameBen(displayData.getSurnameBen());
        beneficiary.setPhoneBen(displayData.getPhoneBen());
        beneficiary.setIDNP(displayData.getIDNP());
        beneficiary.setAddressBen(displayData.getAddressBen());
        beneficiary.setEmailBen(displayData.getEmailBen());

        beneficiariesDAO.update(beneficiary);
        localitiesDAO.update(locality);
        cardsDAO.update(card);
    }

    @Override
    public void delete(DisplayData displayData) throws SQLException {

    }

    @Override
    public DisplayData getObject(int id) throws SQLException {
        return null;
    }


}
