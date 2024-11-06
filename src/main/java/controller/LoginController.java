package controller;

import model.LoginModel;
import model.Model;

import javax.swing.*;

public class LoginController {
    private final Model model;
    private final CreateImage createImage = new CreateImage();

    public LoginController(Model model) {
        this.model = model;
    }

}
