package org.project.mainController;


import org.project.ConfigLoader;
import org.project.Controller;
import org.project.CreateImage;
import org.project.Model;
import org.project.entity.Beneficiaries;
import org.project.entity.DisplayData;
import org.project.mainModel.MainModel;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MainController extends Controller {
    private final MainModel mainModel;

    private final CreateImage createImage;


    public MainController(Model model, MainModel mainModel) {
        super(model);
        this.mainModel = mainModel;

        this.createImage = new CreateImage();
    }

    public List<String[]> returnData() throws SQLException {

        List<String[]> data = new ArrayList<>();

        List<DisplayData> displayData = mainModel.getDisplayData();
        for (DisplayData d : displayData) {
            String[] display = {d.getCodeBen(), d.getNameBen(), d.getSurnameBen(), d.getPhoneBen(), d.getIDNP(), d.getAddressBen(), d.getEmailBen(), d.getLocalityName(),d.getEnvironment(), d.getCardNumber()};
            data.add(display);
        }

        return data;
    }

    public String addOrRemoveTick(String text, boolean value) {
        if (value) return text + "✔";
        return text.substring(0, text.length() - 1);
    }

    public ImageIcon getDeleteImageIcon(){
        ImageIcon icon = new ImageIcon(createImage.createImageIcon(getDeleteIcon()).getImage());
        return icon;
    }

    private String getDeleteIcon() {
        return ConfigLoader.getProperty("img.DELETE_ICON_PATH");
    }

}
