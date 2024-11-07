package org.project.view;

import org.project.controller.Controller;
import org.project.view.components.initLoginComponents;

import javax.swing.*;
import java.awt.*;

public class LoginView extends View {
    private final Controller controller;
    private final initLoginComponents components;

    private JFrame frame;
    private JPanel headerPanel;
    private JPanel containerPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;

    private JLabel logo;
    private JLabel welcomeBackLabel;
    private JLabel enterLoginData;
    private JLabel username;
    private JTextField usernameField;
    private JPanel usernamePanel;
    private JLabel password;
    private JPasswordField passwordField;
    private JPanel passwordPanel;
    private JLabel email;
    private JTextField emailField;
    private JPanel emailPanel;
    private JButton loginButton;

    private JButton iconButton;

    private JLabel noAccountLabel;
    private JLabel signupPrompt;

    private boolean isDarkTheme = false;

    public LoginView(Controller controller) {
        this.controller = controller;
        this.components = new initLoginComponents();
    }

    public void init() {
        frame = new JFrame();
        frame.setTitle("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(new BorderLayout());

        logo = components.getLogo();
        welcomeBackLabel = components.getWelcomeBackLabel();
        enterLoginData = components.getEnterLoginData();
        username = components.getUsername();
        usernameField = components.getUsernameField();
        usernamePanel = components.getUsernamePanel();
        password = components.getPassword();
        passwordField = components.getPasswordField();
        passwordPanel = components.getPasswordPanel();
        email = components.getEmail();
        emailField = components.getEmailField();
        emailPanel = components.getEmailPanel();
        loginButton = components.getLoginButton();

        ImageIcon iconDark = controller.getDarkImageIcon();
        ImageIcon iconLight = controller.getLightImageIcon();
        iconButton = new JButton(isDarkTheme ? iconLight : iconDark);
        iconButton.addActionListener(e -> {
            changeTheme(iconDark, iconLight);
        });

        headerPanel = components.initHeaderPanel(iconButton);

        containerPanel = new JPanel();
        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.X_AXIS));
        containerPanel.setBorder(BorderFactory.createEmptyBorder(50, 200, 50, 50));

        leftPanel = components.getLeftPanel();
        containerPanel.add(leftPanel);

        containerPanel.add(Box.createHorizontalStrut(500));

        rightPanel = components.getRightPanel();
        containerPanel.add(rightPanel);

        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(containerPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void changeTheme(ImageIcon iconDark, ImageIcon iconLight) {
        isDarkTheme = !isDarkTheme;

        iconButton.setIcon(isDarkTheme ? iconLight : iconDark);
        if (isDarkTheme) initDark();
        else initLight();

        SwingUtilities.updateComponentTreeUI(frame);
    }
}
