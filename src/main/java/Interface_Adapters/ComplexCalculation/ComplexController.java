package main.java.Interface_Adapters.ComplexCalculation;

import main.java.Use_Cases.ComplexInteractor.ComplexInputBoundary;
import main.java.Use_Cases.ComplexInteractor.ComplexInputData;
import main.java.Use_Cases.ComplexInteractor.ComplexInteractor;

/**
 * Controller for complex calculation use case
 */
public class ComplexController {

    private final ComplexInputBoundary complexInputBoundary;

    public ComplexController(ComplexInputBoundary complexInputBoundary) {
        this.complexInputBoundary = complexInputBoundary;
    }

    public void enactCalculation(String inputExpression){
        final ComplexInputData complexInputData = new ComplexInputData(inputExpression);
         complexInputBoundary.calculate(complexInputData);
    }
}
