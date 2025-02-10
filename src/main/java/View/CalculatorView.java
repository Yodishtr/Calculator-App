package View;

import Data_Access.ActualGraphingService;
import Interface_Adapters.ComplexCalculation.ComplexController;
import Interface_Adapters.ComplexCalculation.ComplexState;
import Interface_Adapters.ComplexCalculation.ComplexViewModel;
import Interface_Adapters.ViewManagerModel;

import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CalculatorView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "calculator";
    private final JTextField input;
    private final ComplexViewModel complexViewModel;
    private final ComplexController complexController;
    private final ViewManagerModel viewManagerModel;
    private final ActualGraphingService actualGraphingService;


    public CalculatorView(ComplexViewModel complexViewModel, ViewManagerModel viewManagerModel,
                          ComplexController complexController) {
        this.complexViewModel = complexViewModel;
        this.viewManagerModel = viewManagerModel;
        this.complexController = complexController;
        this.actualGraphingService = new ActualGraphingService();


        complexViewModel.addPropertyChangeListener(this);


        setLayout(new BorderLayout());

        input = new JTextField();
        input.setEditable(false);
        input.setFont(new Font("Arial", Font.BOLD, 24));
        input.setHorizontalAlignment(SwingConstants.RIGHT);
        add(input, BorderLayout.NORTH);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));

        buttonPanel.setBackground(Color.BLACK);

        String[] buttons = {"7", "8", "9", " + ", "4", "5", "6", " - ", "1", "2", "3", " * ", "C", "0", "=", " / "};
        for (String button : buttons) {
            JButton calculatorButton = new JButton(button);

            calculatorButton.setFont(new Font("Arial", Font.BOLD, 20));
            calculatorButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleButtonPress(e);
                }
            });
            buttonPanel.add(calculatorButton);
        }
        add(buttonPanel, BorderLayout.CENTER);

        JPanel graphingPanel = new JPanel();
        graphingPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton graphingButton = new JButton("Graph");
        graphingButton.setFont(new Font("Arial", Font.BOLD, 20));
        graphingButton.setBackground(Color.LIGHT_GRAY);
        graphingButton.addActionListener(e -> openGraphingCalculator());
        graphingPanel.add(graphingButton);
        add(graphingPanel, BorderLayout.SOUTH);

    }

    private void handleButtonPress(ActionEvent evt) {
        String command = evt.getActionCommand();


        if (command.equals("C")){
            complexViewModel.setState(new ComplexState());
        } else if(command.equals("=")){
            String expression = complexViewModel.getState().getExpressionToCalculate();

            complexController.enactCalculation(expression);
        } else{
            ComplexState complexState = complexViewModel.getState();
            String updatedExpression = complexState.getExpressionToCalculate() + command;

            complexViewModel.setState(new ComplexState(updatedExpression, updatedExpression, false));
        }
    }

    /**
     * Reacts to property changes in the view model.
     *
     * @param evt the PropertyChangeEvent
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final ComplexState state = (ComplexState) evt.getNewValue();

        updateDisplay(state);

    }

    // add a document listener to the input field
    private void openGraphingCalculator() {
        actualGraphingService.OpenGraphingCalculator();
    }



    /**
     * Updates the display field with the current state.
     *
     * @param state the current ComplexState
     */
    private void updateDisplay(ComplexState state) {
        if (state.getIsResultDisplayed()) {
            input.setText(state.getExpressionToDisplay());

        } else if (!state.getExpressionToCalculate().isEmpty()) {
            input.setText(state.getExpressionToDisplay());

        } else {
            input.setText("");
        }
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Button pressed: " + evt.getActionCommand());
    }

    public String getViewName(){
        return viewName;
    }


}
