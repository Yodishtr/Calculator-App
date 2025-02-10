package Interface_Adapters.ComplexCalculation;

import Use_Cases.ComplexInteractor.ComplexInputBoundary;
import Use_Cases.ComplexInteractor.ComplexInputData;


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
