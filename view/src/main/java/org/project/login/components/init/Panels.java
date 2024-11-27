package org.project.login.components.init;

import javax.swing.*;
import java.awt.*;

public class Panels {
    private final RegisterComponents components;

    public Panels() {
        components = new RegisterComponents();
    }

    public JPanel initAndConfigureHeaderPanel(JButton button) {
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        headerPanel.add(components.getLogo(), BorderLayout.CENTER);
        headerPanel.add(button, BorderLayout.EAST);

        return headerPanel;
    }

    public JPanel initAndConfigureLeftPanel() {
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        leftPanel.setPreferredSize(new Dimension(300, 400));

        leftPanel.add(components.getWelcomeBackLabel());
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(components.getEnterLoginData());
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(components.getUsername());
        leftPanel.add(Box.createVerticalStrut(5));
        leftPanel.add(components.getUsernamePanel());
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(components.getPasswordPanel());
        leftPanel.add(Box.createVerticalStrut(5));
        leftPanel.add(components.getPasswordPanel());
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(components.getEmail());
        leftPanel.add(Box.createVerticalStrut(5));
        leftPanel.add(components.getPasswordPanel());
        leftPanel.add(Box.createVerticalStrut(15));
        leftPanel.add(components.getLoginButton());

        return leftPanel;
    }

    public JPanel initAndConfigureRightPanel() {
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        rightPanel.add(components.getNoAccountLabel());
        rightPanel.add(Box.createVerticalStrut(10));
        rightPanel.add(components.getSignupPrompt());

        return rightPanel;
    }
}
