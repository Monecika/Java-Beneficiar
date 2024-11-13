package org.project.login.components.init;

import org.project.login.components.configure.ConfigureRegisterComponents;

import javax.swing.*;

public class RegisterComponents extends LoginComponents {
    private final ConfigureRegisterComponents components;

    private JLabel noAccountLabel;
    private JLabel signupPrompt;

    public RegisterComponents() {
        super();
        components = new ConfigureRegisterComponents();

        noAccountLabel = components.noAccountLabelConfigure();
        signupPrompt = components.signupPromptLabelConfigure();
    }

    public JLabel getNoAccountLabel() {
        return noAccountLabel;
    }

    public void setNoAccountLabel(JLabel noAccountLabel) {
        this.noAccountLabel = noAccountLabel;
    }

    public JLabel getSignupPrompt() {
        return signupPrompt;
    }

    public void setSignupPrompt(JLabel signupPrompt) {
        this.signupPrompt = signupPrompt;
    }

    @Override
    public String toString() {
        return "initRegisterComponents{" + "noAccountLabel=" + noAccountLabel + ", signupPrompt=" + signupPrompt + '}';
    }
}
