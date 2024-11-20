package org.project.loginController;

import org.project.Controller;
import org.project.CreateImage;
import org.project.Model;
import org.project.loginModel.LoginModel;

public class LoginController extends Controller {
    private final LoginModel loginModel;

    public LoginController(Model model, LoginModel loginModel) {
        super(model);
        this.loginModel = loginModel;
    }

}
