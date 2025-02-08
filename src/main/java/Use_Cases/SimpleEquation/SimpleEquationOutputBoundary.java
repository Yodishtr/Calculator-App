package main.java.Use_Cases.SimpleEquation;

/**
 * output boundary for equation use case
 */
public interface SimpleEquationOutputBoundary {
    /**
     * prepares success view for simple equation use case
     */
    void prepareSuccessView(SimpleEquationOutputData outputData);

    /**
     * prepares fail view for simple equation use case
     */
    void prepareFailView(String outputData);
}
