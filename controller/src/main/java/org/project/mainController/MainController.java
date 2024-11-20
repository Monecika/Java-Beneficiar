package org.project.mainController;


import org.project.Controller;
import org.project.Model;
import org.project.entity.Beneficiaries;
import org.project.mainModel.MainModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MainController extends Controller {
    private final MainModel mainModel;

    public MainController(Model model, MainModel mainModel) {
        super(model);
        this.mainModel = mainModel;
    }

    public List<String[]> returnData() throws SQLException {
        List<String[]> data = new ArrayList<>();

        List<Beneficiaries> bens = mainModel.getBeneficiaries();
        for (Beneficiaries b : bens) {
            String[] beneficiar = {b.getCodeBen(), b.getNameBen(), b.getSurnameBen(), b.getPhoneBen(), b.getIDNP(), b.getAddressBen(), b.getEmailBen(), String.valueOf(b.getLocalityID()),b.getEnvironment(), String.valueOf(b.getCardID())};

            data.add(beneficiar);
        }

        return data;
    }

    public String addOrRemoveTick(String text, boolean value) {
        if (value) return text + "✔";
        return text.substring(0, text.length() - 1);
    }
}
