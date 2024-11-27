package org.project.DAO.entityDAO;

import org.project.DAO.CrudDAO;
import org.project.entity.Beneficiaries;
import org.project.entity.ScepticData;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScepticDataDAOImplementation implements CrudDAO<ScepticData> {
    @Override
    public List<ScepticData> getAll() throws SQLException {
        BeneficiariesDAOImplement beneficiariesDAO = new BeneficiariesDAOImplement();

        List<Beneficiaries> beneficiariesList = beneficiariesDAO.getAll();
        List<ScepticData> scepticDataList = new ArrayList<>();

        ScepticData scepticData;
        Beneficiaries beneficiaries;

        while (!beneficiariesList.isEmpty()) {
            beneficiaries = beneficiariesList.getFirst();
            scepticData = new ScepticData(beneficiaries.getID(), beneficiaries.getCodeBen(), beneficiaries.getNameBen(), beneficiaries.getSurnameBen(), beneficiaries.getPhoneBen(), beneficiaries.getAddressBen(), beneficiaries.getEmailBen());
            scepticDataList.add(scepticData);
            beneficiariesList.removeFirst();
        }
        return scepticDataList;
    }

    @Override
    public ScepticData getObject(int id) {
        return null;
    }

    @Override
    public void add(ScepticData scepticData) throws SQLException {

    }

    @Override
    public void update(ScepticData scepticData) throws SQLException {

    }

    @Override
    public void delete(ScepticData scepticData) throws SQLException {

    }
}
