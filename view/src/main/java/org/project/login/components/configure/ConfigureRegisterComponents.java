package org.project.login.components.configure;

import javax.swing.*;
import java.awt.*;

public class ConfigureRegisterComponents {
    public ConfigureRegisterComponents() {
    }

    public JLabel noAccountLabelConfigure() {
        JLabel noAccountLabel = new JLabel("Do not have an Account?");
        noAccountLabel.setForeground(new Color(0, 150, 0));
        noAccountLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        return noAccountLabel;
    }

    public JLabel signupPromptLabelConfigure() {
        JLabel signupPrompt = new JLabel("<html>If you do not have an account already,<br>create one by clicking <a href='#'>Sign Up</a></html>");
        signupPrompt.setFont(new Font("SansSerif", Font.PLAIN, 14));
        return signupPrompt;
    }
}
