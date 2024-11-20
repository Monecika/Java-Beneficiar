package org.project;

import org.project.login.LoginView;
import org.project.loginController.LoginController;
import org.project.loginModel.LoginModel;
import org.project.main.MainView;
import org.project.mainController.MainController;
import org.project.mainModel.MainModel;

import javax.swing.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        LoginModel loginModel = new LoginModel();
        MainModel mainModel = new MainModel();

        Controller controller = new Controller(model);
        LoginController loginController = new LoginController(model, loginModel);
        MainController mainController = new MainController(model, mainModel);

        MainView mainView = new MainView(controller, mainController);
        LoginView loginView = new LoginView(controller, loginController);

        SwingUtilities.invokeLater(() -> {
            try {
                mainView.init();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }
}