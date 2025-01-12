package main.java.Interface_Adapters.ComplexCalculation;

import main.java.Interface_Adapters.ViewManagerModel;
import main.java.Use_Cases.ComplexInteractor.ComplexOutputBoundary;
import main.java.Use_Cases.ComplexInteractor.ComplexOutputData;

/**
 * Presenter for the complex calculation use case
 */
public class ComplexPresenter implements ComplexOutputBoundary {
    private final ComplexViewModel complexViewModel;
    private final ViewManagerModel viewManagerModel;

    public ComplexPresenter(ComplexViewModel complexViewModel, ViewManagerModel viewManagerModel) {
        this.complexViewModel = complexViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(ComplexOutputData outputData) {

    }

    @Override
    public void prepareFailView(String errorMessage) {

    }
}
