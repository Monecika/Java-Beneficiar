package org.project.DAO.entityDAO;

import org.project.ConfigLoader;
import org.project.DAO.CrudDAO;
import org.project.Database;
import org.project.entity.Beneficiaries;
import org.project.entity.Cards;
import org.project.entity.DisplayData;
import org.project.entity.Localities;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DisplayDataDAOImplement implements CrudDAO<DisplayData> {
    private final BeneficiariesDAOImplement beneficiariesDAO;
    private final CardsDAOImplement cardsDAO;
    private final LocalitiesDAOImplement localitiesDAO;

    // For Beneficiaries
    private final static String SQL_SELECT_BEN = ConfigLoader.getProperty("sql.SQL_SELECT_BENEFICIARIES");
    private final static String SQL_INSERT_BEN = ConfigLoader.getProperty("sql.SQL_INSERT_BENEFICIARIES");
    private final static String SQL_UPDATE_BEN = ConfigLoader.getProperty("sql.SQL_UPDATE_BENEFICIARIES");
    private final static String SQL_DELETE_BEN = ConfigLoader.getProperty("sql.SQL_DELETE_BENEFICIARIES");

    // For Cards
    private final static String SQL_SELECT_CARDS = ConfigLoader.getProperty("sql.SQL_SELECT_CARDS");
    private final static String SQL_INSERT_CARD = ConfigLoader.getProperty("sql.SQL_INSERT_CARD");
    private final static String SQL_UPDATE_CARD = ConfigLoader.getProperty("sql.SQL_UPDATE_CARD");
    private final static String SQL_DELETE_CARD = ConfigLoader.getProperty("sql.SQL_DELETE_CARD");

    // For Localities
    private final static String SQL_SELECT_LOCALITIES = ConfigLoader.getProperty("sql.SQL_SELECT_LOCALITIES");
    private final static String SQL_INSERT_LOCALITY = ConfigLoader.getProperty("sql.SQL_INSERT_LOCALITY");
    private final static String SQL_UPDATE_LOCALITY = ConfigLoader.getProperty("sql.SQL_UPDATE_LOCALITY");
    private final static String SQL_DELETE_LOCALITY = ConfigLoader.getProperty("sql.SQL_DELETE_LOCALITY");


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

        Beneficiaries beneficiaries = null;
        Localities localities = null;
        Cards cards = null;

        while(beneficiariesList.size()>0) {
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


        }

        return List.of();
    }


    @Override
    public void add(DisplayData displayData) throws SQLException {

    }

    @Override
    public void update(DisplayData displayData) throws SQLException {

    }

    @Override
    public void delete(DisplayData displayData) throws SQLException {

    }

    @Override
    public DisplayData getObject(int id) throws SQLException {
        return null;
    }


}
