package view;

import controller.MainController;
import view.components.initMainComponents;

import javax.swing.*;
import java.awt.*;

public class MainView {
    private final MainController controller;
    private final initMainComponents init = new initMainComponents();

    private JFrame frame;
    private JPanel headerPanel;
    private JPanel bodyPanel;


    public MainView(MainController controller) {
        this.controller = controller;
    }

    public void initLight() {
        frame = new JFrame();
        frame.setTitle("Beneficiaris");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

//        FlatDarkLaf.setup();

        headerPanel = init.initHeader();
        bodyPanel = init.initBody();

        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(bodyPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
