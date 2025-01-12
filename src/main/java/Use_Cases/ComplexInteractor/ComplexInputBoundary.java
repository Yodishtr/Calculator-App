package main.java.Use_Cases.ComplexInteractor;

import main.java.Entity.Numbers;

/**
 * Input boundary for complex calculation
 */
public interface ComplexInputBoundary {

    /**
     * Executes the complex calculation use case
     * @param complexInputData
     */
    void calculate(ComplexInputData complexInputData);
}
