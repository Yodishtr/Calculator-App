package main.java.Interface_Adapters.ComplexCalculation;

import main.java.Interface_Adapters.ViewManagerModel;
import main.java.Use_Cases.ComplexInteractor.ComplexInteractor;

public class ApplicationFactory {
    private ComplexViewModel complexViewModel;
    private ViewManagerModel viewManagerModel;
    private ComplexController complexController;

    // Create or retrieve the ComplexViewModel
    public ComplexViewModel getViewModel() {
        if (complexViewModel == null) {
            complexViewModel = new ComplexViewModel();
        }
        return complexViewModel;
    }

    // Create or retrieve the ViewManagerModel
    public ViewManagerModel getViewManagerModel() {
        if (viewManagerModel == null) {
            viewManagerModel = new ViewManagerModel();
        }
        return viewManagerModel;
    }

    // Create or retrieve the ComplexController
    public ComplexController createController() {
        if (complexController == null) {
            ComplexPresenter presenter = new ComplexPresenter(getViewModel(), getViewManagerModel());
            ComplexInteractor interactor = new ComplexInteractor(presenter);
            complexController = new ComplexController(interactor);
        }
        return complexController;
    }
}
