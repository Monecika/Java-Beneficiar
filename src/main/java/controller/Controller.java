package controller;

import model.Model;

import javax.swing.*;

public class Controller {
    private final Model model;

    private final LoginController loginController;
    private final MainController mainController;
    private final CreateImage createImage;

    public Controller(Model model) {
        this.model = model;
        this.loginController = new LoginController(model);
        this.mainController = new MainController(model);
        this.createImage = new CreateImage();
    }

    public ImageIcon createImageIcon(String path) {
        return createImage.createImageIcon(path);
    }

    public String getDarkIcon() {
        return model.getProperty("DARK_ICON_PATH");
    }

    public String getLightIcon() {
        return model.getProperty("LIGHT_ICON_PATH");
    }
}
