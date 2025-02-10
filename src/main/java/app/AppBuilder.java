package app;

import Interface_Adapters.ComplexCalculation.ApplicationFactory;
import Interface_Adapters.ComplexCalculation.ComplexController;

import Interface_Adapters.ComplexCalculation.ComplexViewModel;
import Interface_Adapters.ViewManagerModel;
import View.CalculatorView;
import View.ViewManager;

import javax.swing.*;
import java.awt.*;

public class AppBuilder {
    private final JPanel cardPanel = new JPanel();
    private final CardLayout cardLayout = new CardLayout();
    private final ViewManagerModel viewManagerModel = new ViewManagerModel();
    private final ViewManager viewManager = new ViewManager(cardPanel, cardLayout, viewManagerModel);



    public AppBuilder() {
        cardPanel.setLayout(cardLayout);
        viewManagerModel.addPropertyChangeListener(viewManager);
    }

    public AppBuilder addCalculatorView(){
        ApplicationFactory applicationFactory = new ApplicationFactory();
        ComplexController complexController = applicationFactory.createController();
        ComplexViewModel complexViewModel = applicationFactory.getViewModel();
        CalculatorView calculatorView = new CalculatorView(complexViewModel, viewManagerModel, complexController);
        cardPanel.add(calculatorView, calculatorView.getViewName());
        return this;

    }

    public JFrame build() {
        final JFrame applicationFrame = new JFrame("My Calculator");
        applicationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        applicationFrame.add(cardPanel);
        viewManagerModel.setState("calculator");
        viewManagerModel.firePropertyChanged();
        return applicationFrame;
    }

}
