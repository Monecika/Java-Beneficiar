package org.project.controller;

import org.project.model.Model;

public class LoginController {
    private final Model model;
    private final CreateImage createImage = new CreateImage();

    public LoginController(Model model) {
        this.model = model;
    }

}
