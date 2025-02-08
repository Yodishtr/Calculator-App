package main.java.Use_Cases.SimpleEquation;

/**
 * input data for a simple equation (contains only one variable)
 */
public class SimpleEquationInputData {
    private final String equation;

    public SimpleEquationInputData(String equation){
        this.equation = equation;
    }

    public String getEquation() {
        return equation;
    }
}
