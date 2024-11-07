package org.project.login.controller;

import org.project.app.controller.CreateImage;
import org.project.app.model.Model;

public class LoginController {
    private final Model model;
    private final CreateImage createImage = new CreateImage();

    public LoginController(Model model) {
        this.model = model;
    }

}
