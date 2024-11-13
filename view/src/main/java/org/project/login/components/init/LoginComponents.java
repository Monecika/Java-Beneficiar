package org.project.login.components.init;

import org.project.login.components.configure.ConfigureLoginComponents;

import javax.swing.*;

public class LoginComponents {
    private final JLabel username = new JLabel("Username");
    private final JLabel password = new JLabel("Password");
    private final JLabel email = new JLabel("Email");
    private final ConfigureLoginComponents components;
    private JLabel logo;
    private JLabel welcomeBackLabel;
    private JLabel enterLoginData;
    private JTextField usernameField;
    private JPanel usernamePanel;
    private JPasswordField passwordField;
    private JPanel passwordPanel;
    private JTextField emailField;
    private JPanel emailPanel;
    private JButton loginButton;

    public LoginComponents() {
        components = new ConfigureLoginComponents();

        logo = components.logoLabelConfigure();
        welcomeBackLabel = components.welcomeBackLabelConfigure();
        enterLoginData = components.enterLoginDataConfigure();
        usernameField = components.fieldConfigure();
        usernamePanel = components.panelConfigure(usernameField);
        passwordField = components.passConfigure();
        passwordPanel = components.passPanelConfigure(passwordField);
        emailField = components.fieldConfigure();
        emailPanel = components.panelConfigure(emailField);
        loginButton = components.loginButtonConfigure();

    }

    public JLabel getLogo() {
        return logo;
    }

    public void setLogo(JLabel logo) {
        this.logo = logo;
    }

    public JLabel getWelcomeBackLabel() {
        return welcomeBackLabel;
    }

    public void setWelcomeBackLabel(JLabel welcomeBackLabel) {
        this.welcomeBackLabel = welcomeBackLabel;
    }

    public JLabel getEnterLoginData() {
        return enterLoginData;
    }

    public void setEnterLoginData(JLabel enterLoginData) {
        this.enterLoginData = enterLoginData;
    }

    public JLabel getUsername() {
        return username;
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public void setUsernameField(JTextField usernameField) {
        this.usernameField = usernameField;
    }

    public JPanel getUsernamePanel() {
        return usernamePanel;
    }

    public void setUsernamePanel(JPanel usernamePanel) {
        this.usernamePanel = usernamePanel;
    }

    public JLabel getPassword() {
        return password;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public JPanel getPasswordPanel() {
        return passwordPanel;
    }

    public void setPasswordPanel(JPanel passwordPanel) {
        this.passwordPanel = passwordPanel;
    }

    public JLabel getEmail() {
        return email;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public void setEmailField(JTextField emailField) {
        this.emailField = emailField;
    }

    public JPanel getEmailPanel() {
        return emailPanel;
    }

    public void setEmailPanel(JPanel emailPanel) {
        this.emailPanel = emailPanel;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(JButton loginButton) {
        this.loginButton = loginButton;
    }

    @Override
    public String toString() {
        return "initLoginComponents{" + "logo=" + logo + ", welcomeBackLabel=" + welcomeBackLabel + ", enterLoginData=" + enterLoginData + ", username=" + username + ", usernameField=" + usernameField + ", usernamePanel=" + usernamePanel + ", password=" + password + ", passwordField=" + passwordField + ", passwordPanel=" + passwordPanel + ", email=" + email + ", emailField=" + emailField + ", emailPanel=" + emailPanel + ", loginButton=" + loginButton + '}';
    }
}
