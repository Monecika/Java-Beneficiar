package org.project;

import controller.Controller;
import model.Model;
import view.LoginView;
import view.MainView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);

//        MainModel mainModel = new MainModel();
//        MainController mainController = new MainController(mainModel);
        MainView mainView = new MainView(controller);

//        LoginModel loginModel = new LoginModel();
//        LoginController loginController = new LoginController(loginModel);
        LoginView loginView = new LoginView(controller);

        SwingUtilities.invokeLater(() -> mainView.initLight());
    }
}