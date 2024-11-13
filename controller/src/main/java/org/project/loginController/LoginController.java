package org.project.loginController;

import org.project.CreateImage;
import org.project.Model;

public class LoginController {
    private final Model model;
    private final CreateImage createImage = new CreateImage();

    public LoginController(Model model) {
        this.model = model;
    }

}
