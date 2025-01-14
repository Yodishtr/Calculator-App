package main.java.Interface_Adapters.ComplexCalculation;

import main.java.Use_Cases.ComplexInteractor.ComplexInputBoundary;
import main.java.Use_Cases.ComplexInteractor.ComplexInputData;
import main.java.Use_Cases.ComplexInteractor.ComplexInteractor;

/**
 * Controller for complex calculation use case
 */
public class ComplexController {

    private final ComplexInputBoundary complexInteractor;

    public ComplexController(ComplexInputBoundary complexInteractor) {
        this.complexInteractor = complexInteractor;
    }

    public void enactCalculation(String inputExpression){
        final ComplexInputData complexInputData = new ComplexInputData(inputExpression);

         complexInteractor.calculate(complexInputData);
    }
}
