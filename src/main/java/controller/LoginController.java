package controller;

import model.LoginModel;

import javax.swing.*;

public class LoginController {
    private final LoginModel model;
    private final CreateImage createImage = new CreateImage();

    public LoginController(LoginModel loginModel) {
        this.model = loginModel;
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
