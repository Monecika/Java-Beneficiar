package org.project.login.components.init;

import org.project.login.components.configure.ConfigureRegisterComponents;

import javax.swing.*;

public class RegisterComponents extends LoginComponents {
    private final ConfigureRegisterComponents components;

    private final JLabel noAccountLabel;
    private final JLabel signupPrompt;

    public RegisterComponents() {
        super();
        components = new ConfigureRegisterComponents();

        noAccountLabel = components.noAccountLabelConfigure();
        signupPrompt = components.signupPromptLabelConfigure();
    }

    public JLabel getNoAccountLabel() {
        return noAccountLabel;
    }

    public JLabel getSignupPrompt() {
        return signupPrompt;
    }

    @Override
    public String toString() {
        return "initRegisterComponents{" + "noAccountLabel=" + noAccountLabel + ", signupPrompt=" + signupPrompt + '}';
    }
}
