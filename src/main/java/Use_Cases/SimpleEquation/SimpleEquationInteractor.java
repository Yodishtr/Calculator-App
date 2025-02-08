package main.java.Use_Cases.SimpleEquation;

import main.java.Entity.Expression;
import main.java.Use_Cases.ComplexInteractor.ComplexInputData;

import java.util.ArrayList;

/**
 * use case interactor handling solving simple equations
 */
public class SimpleEquationInteractor implements SimpleEquationInputBoundary{
    private final SimpleEquationOutputBoundary EquationOutputBoundary;

    public SimpleEquationInteractor(SimpleEquationOutputBoundary EquationOutputBoundary) {
        this.EquationOutputBoundary = EquationOutputBoundary;
    }

    @Override
    public void solve(SimpleEquationInputData simpleEquation){
        // TODO need to find a way to solve equations
    }



}
