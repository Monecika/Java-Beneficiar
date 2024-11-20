package org.project;

import org.project.loginController.LoginController;
import org.project.mainController.MainController;

import javax.swing.*;

public class Controller {
    private final Model model;

    private final CreateImage createImage;

    public Controller(Model model) {
        this.model = model;

        this.createImage = new CreateImage();
    }


    public ImageIcon getDarkImageIcon() {
        ImageIcon icon = new ImageIcon(createImage.createImageIcon(getDarkIcon()).getImage());
        return icon;
    }

    public ImageIcon getLightImageIcon() {
        ImageIcon icon = new ImageIcon(createImage.createImageIcon(getLightIcon()).getImage());
        return icon;
    }

    public String getDarkIcon() {
        return ConfigLoader.getProperty("img.DARK_ICON_PATH");
    }

    private String getLightIcon() {
        return ConfigLoader.getProperty("img.LIGHT_ICON_PATH");
    }
}
