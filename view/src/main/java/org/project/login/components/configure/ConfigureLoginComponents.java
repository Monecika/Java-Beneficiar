package org.project.login.components.configure;

import javax.swing.*;
import java.awt.*;

public class ConfigureLoginComponents {
    public ConfigureLoginComponents() {
    }

    public JLabel logoLabelConfigure() {
        JLabel logo = new JLabel("LOGO", SwingConstants.CENTER);
        logo.setFont(new Font("SansSerif", Font.BOLD, 24));
        return logo;
    }

    public JLabel welcomeBackLabelConfigure() {
        JLabel welcomeBackLabel = new JLabel("Welcome Back");
        welcomeBackLabel.setForeground(new Color(0, 150, 0));
        welcomeBackLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        return welcomeBackLabel;
    }

    public JLabel enterLoginDataConfigure() {
        JLabel enterLoginData = new JLabel("Enter the credentials to login");
        enterLoginData.setFont(new Font("SansSerif", Font.PLAIN, 14));
        return enterLoginData;
    }

    public JTextField fieldConfigure() {
        JTextField field = new JTextField(20);
        field.setMaximumSize(new Dimension(500, 25));
        return field;
    }

    public JPanel panelConfigure(JTextField field) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));
        panel.add(field);
        return panel;
    }

    public JPasswordField passConfigure() {
        JPasswordField field = new JPasswordField(20);
        field.setMaximumSize(new Dimension(500, 25));
        return field;
    }

    public JPanel passPanelConfigure(JPasswordField field) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));
        panel.add(field);
        return panel;
    }

    public JButton loginButtonConfigure() {
        JButton loginButton = new JButton("Sign In");
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(new Color(0, 150, 0));
        loginButton.setMaximumSize(new Dimension(250, 30));
        return loginButton;
    }
}
