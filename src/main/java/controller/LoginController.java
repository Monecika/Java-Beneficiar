package controller;

import model.LoginModel;

import javax.swing.*;

public class LoginController {
    private final LoginModel loginModel;
    private final CreateImage createImage = new CreateImage();

    public LoginController(LoginModel loginModel) {
        this.loginModel = loginModel;
    }

    public ImageIcon createImageIcon(String path) {
        return createImage.createImageIcon(path);
    }
}
