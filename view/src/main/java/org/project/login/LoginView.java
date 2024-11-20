package org.project.login;

import org.project.Controller;
import org.project.View;
import org.project.login.components.init.Panels;
import org.project.login.components.init.RegisterComponents;
import org.project.loginController.LoginController;

import javax.swing.*;
import java.awt.*;

public class LoginView extends View {
    private final LoginController loginController;

    private final RegisterComponents components;
    private final Panels panels;

    private JFrame frame;
    private JPanel headerPanel;
    private JPanel containerPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;

    private JButton iconButton;

    private JLabel noAccountLabel;
    private JLabel signupPrompt;

    private boolean isDarkTheme = false;

    public LoginView(Controller controller, LoginController loginController) {
        super(controller);
        this.loginController = loginController;

        this.components = new RegisterComponents();
        this.panels = new Panels();
    }

    public void init() {
        frame = new JFrame();
        frame.setTitle("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(new BorderLayout());

        iconButton = initIconButton();
        iconButton.addActionListener(e -> {
            changeTheme();
        });

        headerPanel = panels.initAndConfigureHeaderPanel(iconButton);

        containerPanel = new JPanel();
        containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.X_AXIS));
        containerPanel.setBorder(BorderFactory.createEmptyBorder(50, 200, 50, 50));

        leftPanel = panels.initAndConfigureLeftPanel();
        containerPanel.add(leftPanel);

        containerPanel.add(Box.createHorizontalStrut(500));

        rightPanel = panels.initAndConfigureRightPanel();
        containerPanel.add(rightPanel);

        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(containerPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void changeTheme() {
        isDarkTheme = !isDarkTheme;

        iconButton.setIcon(isDarkTheme ? getIconLight() : getIconDark());
        if (isDarkTheme) initDark();
        else initLight();

        SwingUtilities.updateComponentTreeUI(frame);
    }
}
