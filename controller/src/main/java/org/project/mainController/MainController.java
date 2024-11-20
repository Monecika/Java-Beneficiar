package org.project.mainController;


import org.project.Controller;
import org.project.Model;
import org.project.mainModel.MainModel;


public class MainController extends Controller {
    private final MainModel mainModel;

    public MainController(Model model, MainModel mainModel) {
        super(model);
        this.mainModel = mainModel;
    }

    public String addOrRemoveTick(String text, boolean value) {
        if (value) return text + "✔";
        return text.substring(0, text.length() - 1);
    }
}
