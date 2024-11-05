package org.project;

import controller.LoginController;
import controller.MainController;
import model.LoginModel;
import model.MainModel;
import view.LoginView;
import view.MainView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        MainModel mainModel = new MainModel();
        MainController mainController = new MainController(mainModel);
        MainView mainView = new MainView(mainController);

        LoginModel loginModel = new LoginModel();
        LoginController loginController = new LoginController(loginModel);
        LoginView loginView = new LoginView(loginController);

        SwingUtilities.invokeLater(() -> mainView.initLight());
    }
}