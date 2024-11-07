package org.project;

import org.project.controller.Controller;
import org.project.model.Model;
import org.project.view.LoginView;
import org.project.view.MainView;

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