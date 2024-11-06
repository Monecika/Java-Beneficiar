package view;

import controller.Controller;
import controller.MainController;
import view.components.initMainComponents;

import javax.swing.*;
import java.awt.*;

public class MainView {
    private final Controller controller;
    private final initMainComponents init = new initMainComponents();

    private JFrame frame;
    private JPanel headerPanel;
    private JPanel bodyPanel;


    public MainView(Controller controller) {
        this.controller = controller;
    }

    public void initLight() {
        frame = new JFrame();
        frame.setTitle("Beneficiaris");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

//        FlatDarkLaf.setup();

        headerPanel = init.initHeader(controller.getDarkIcon());
        bodyPanel = init.initBody();

        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(bodyPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
