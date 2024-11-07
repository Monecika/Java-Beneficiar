package org.project.view.components;

import org.project.controller.CreateImage;

import javax.swing.*;
import java.awt.*;

public class initLoginComponents {
    private final CreateImage createImage = new CreateImage();

    private JPanel headerPanel;
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

    private JLabel noAccountLabel;
    private JLabel signupPrompt;

    public initLoginComponents() {
        initLogo();
        initLoginFields();
        initRegisterFields();
        initLeftPanel();
        initRightPanel();
    }

    private void initLogo() {
        logo = new JLabel("LOGO", SwingConstants.CENTER);
        logo.setFont(new Font("SansSerif", Font.BOLD, 24));
    }

    private void initLoginFields() {

        welcomeBackLabel = new JLabel("Welcome Back");
        welcomeBackLabel.setForeground(new Color(0, 150, 0));
        welcomeBackLabel.setFont(new Font("SansSerif", Font.BOLD, 20));

        enterLoginData = new JLabel("Enter the credentials to login");
        enterLoginData.setFont(new Font("SansSerif", Font.PLAIN, 14));

        username = new JLabel("Username");
        usernameField = new JTextField(20);
        usernameField.setMaximumSize(new Dimension(500, 25));
        usernamePanel = new JPanel();
        usernamePanel.setLayout(new BoxLayout(usernamePanel, BoxLayout.X_AXIS));
        usernamePanel.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));
        usernamePanel.add(usernameField);

        password = new JLabel("Password");
        passwordField = new JPasswordField(20);
        passwordField.setMaximumSize(new Dimension(500, 25));
        passwordPanel = new JPanel();
        passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.Y_AXIS));
        passwordPanel.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));
        passwordPanel.add(passwordField);


        email = new JLabel("Email");
        emailField = new JTextField(20);
        emailField.setMaximumSize(new Dimension(480, 25));
        emailPanel = new JPanel();
        emailPanel.setLayout(new BoxLayout(emailPanel, BoxLayout.X_AXIS));
        emailPanel.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));
        emailPanel.add(emailField);

        loginButton = new JButton("Sign In");
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(new Color(0, 150, 0));
        loginButton.setMaximumSize(new Dimension(250, 30));
    }

    private void initRegisterFields() {
        noAccountLabel = new JLabel("Do not have an Account?");
        noAccountLabel.setForeground(new Color(0, 150, 0));
        noAccountLabel.setFont(new Font("SansSerif", Font.BOLD, 20));

        signupPrompt = new JLabel("<html>If you do not have an account already,<br>create one by clicking <a href='#'>Sign Up</a></html>");
        signupPrompt.setFont(new Font("SansSerif", Font.PLAIN, 14));

    }

    private void initLeftPanel() {
        leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        leftPanel.setPreferredSize(new Dimension(300, 400));

        leftPanel.add(welcomeBackLabel);
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(enterLoginData);
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(username);
        leftPanel.add(Box.createVerticalStrut(5));
        leftPanel.add(usernamePanel);
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(password);
        leftPanel.add(Box.createVerticalStrut(5));
        leftPanel.add(passwordPanel);
        leftPanel.add(Box.createVerticalStrut(10));
        leftPanel.add(email);
        leftPanel.add(Box.createVerticalStrut(5));
        leftPanel.add(emailPanel);
        leftPanel.add(Box.createVerticalStrut(15));
        leftPanel.add(loginButton);
    }

    private void initRightPanel() {
        rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        rightPanel.add(noAccountLabel);
        rightPanel.add(Box.createVerticalStrut(10));
        rightPanel.add(signupPrompt);
    }

    public JPanel initHeaderPanel(JButton button) {
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));

        headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        headerPanel.add(logo, BorderLayout.CENTER);
        headerPanel.add(button, BorderLayout.EAST);

        return headerPanel;
    }

    public JPanel getHeaderPanel() {
        return headerPanel;
    }

    public JPanel getLeftPanel() {
        return leftPanel;
    }

    public JPanel getRightPanel() {
        return rightPanel;
    }

    public JLabel getLogo() {
        return logo;
    }

    public JLabel getWelcomeBackLabel() {
        return welcomeBackLabel;
    }

    public JLabel getEnterLoginData() {
        return enterLoginData;
    }

    public JLabel getUsername() {
        return username;
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public JPanel getUsernamePanel() {
        return usernamePanel;
    }

    public JLabel getPassword() {
        return password;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JPanel getPasswordPanel() {
        return passwordPanel;
    }

    public JLabel getEmail() {
        return email;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public JPanel getEmailPanel() {
        return emailPanel;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JLabel getNoAccountLabel() {
        return noAccountLabel;
    }

    public JLabel getSignupPrompt() {
        return signupPrompt;
    }
}
