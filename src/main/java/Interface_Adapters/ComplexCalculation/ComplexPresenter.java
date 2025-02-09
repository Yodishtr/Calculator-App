package Interface_Adapters.ComplexCalculation;

import Interface_Adapters.ViewManagerModel;
import Use_Cases.ComplexInteractor.ComplexOutputBoundary;
import Use_Cases.ComplexInteractor.ComplexOutputData;

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
        final ComplexState complexState = complexViewModel.getState();
        complexState.setExpressionToCalculate("");
        complexState.setExpressionToDisplay(errorMessage);
        complexState.setIsResultDisplayed(false);
        complexViewModel.setState(complexState);
        complexViewModel.firePropertyChanged();

    }
}
