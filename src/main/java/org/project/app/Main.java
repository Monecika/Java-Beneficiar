package org.project.app;

import org.project.app.controller.Controller;
import org.project.app.model.Model;
import org.project.login.view.LoginView;
import org.project.main.view.MainView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);

//        MainView mainView = new MainView(controller);
        LoginView loginView = new LoginView(controller);

        SwingUtilities.invokeLater(() -> loginView.init());
    }
}