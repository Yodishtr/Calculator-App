package main.java.Use_Cases.ComplexInteractor;

/**
 * The output boundary for the ComplexCalculation use case
 */
public interface ComplexOutputBoundary {
    /**
     * Prepares the success view for the ComplexCalculation Use Case.
     * @param outputData the explanation of the failure
     */
    void prepareSuccessView(ComplexOutputData outputData);

    /**
     * Prepares the failure view for the ComplexCalculation Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);
}
