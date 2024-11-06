package view;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;

public class View{
    public View() {
    }

    protected void initDark() {
        FlatDarkLaf.setup();
    }

    protected void initLight() {
        FlatLightLaf.setup();
    }

}
