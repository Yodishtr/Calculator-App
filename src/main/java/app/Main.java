package app;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        final AppBuilder appBuilder = new AppBuilder();
        final JFrame theApplication = appBuilder.addCalculatorView().build();

        theApplication.pack();
        theApplication.setVisible(true);
    }
}
