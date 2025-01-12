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
        final ComplexState complexState = complexViewModel.getState();
        final String expression = outputData.getExpressionInput();
        final String result = outputData.getWordValue();
        complexState.setExpressionToCalculate(expression);
        complexState.setExpressionToDisplay(result);
        complexState.setIsResultDisplayed(true);
        complexViewModel.setState(complexState);
        complexViewModel.firePropertyChanged();

        viewManagerModel.setState(complexViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

    }

    @Override
    public void prepareFailView(String errorMessage) {

    }
}
