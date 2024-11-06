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
//        View view = new View(controller);

        MainView mainView = new MainView(controller);
        LoginView loginView = new LoginView(controller);

        SwingUtilities.invokeLater(() -> mainView.init());
    }
}