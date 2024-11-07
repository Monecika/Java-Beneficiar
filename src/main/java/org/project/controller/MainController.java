package org.project.controller;

import org.project.model.Model;

public class MainController {
    private final Model model;

    public MainController(Model model) {
        this.model = model;
    }

    public String addOrRemoveTick(String text, boolean value) {
        if (value) return text + "✔";
        return text.substring(0, text.length() - 1);
    }
}
