package org.project.DAO.entityDAO;

import org.project.DAO.CrudDAO;
import org.project.entity.Beneficiaries;
import org.project.entity.Cards;
import org.project.entity.DisplayData;
import org.project.entity.Localities;

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

        DisplayData displayData;
        Beneficiaries beneficiaries;
        Localities localities;
        Cards cards;

        while (!beneficiariesList.isEmpty()) {
            beneficiaries = beneficiariesList.getFirst();
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
    public DisplayData getObject(int id) {
        return null;
    }

    @Override
    public void add(DisplayData displayData) throws SQLException {
        Localities locality = localitiesDAO.getLocality(displayData.getLocalityName());
        Cards card = cardsDAO.getCard(displayData.getCardNumber());

        int number = beneficiariesDAO.getAll().size() + 1;
        String code = "BEN" + number;
        displayData.setCodeBen(code);
        Beneficiaries beneficiary = new Beneficiaries(0, displayData.getCodeBen(), displayData.getNameBen(), displayData.getSurnameBen(), displayData.getPhoneBen(), displayData.getIDNP(), displayData.getAddressBen(), displayData.getEmailBen(), locality.getID(), displayData.getEnvironment(), card.getID());

        beneficiariesDAO.add(beneficiary);
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
}
