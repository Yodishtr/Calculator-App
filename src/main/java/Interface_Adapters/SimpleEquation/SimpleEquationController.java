package main.java.Interface_Adapters.SimpleEquation;

import main.java.Use_Cases.SimpleEquation.SimpleEquationInputBoundary;
import main.java.Use_Cases.SimpleEquation.SimpleEquationInputData;

public class SimpleEquationController {

    private final SimpleEquationInputBoundary simpleEquationInteractor;

    public SimpleEquationController(SimpleEquationInputBoundary simpleEquationInteractor) {
        this.simpleEquationInteractor = simpleEquationInteractor;
    }

    public void findValue(String inputExpression){
        final SimpleEquationInputData someEquation= new SimpleEquationInputData(inputExpression);
        simpleEquationInteractor.solve(someEquation);
    }

}
