package org.project;

import org.project.login.LoginView;
import org.project.main.MainView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);

        MainView mainView = new MainView(controller);
        LoginView loginView = new LoginView(controller);

        SwingUtilities.invokeLater(() -> mainView.init());
    }
}