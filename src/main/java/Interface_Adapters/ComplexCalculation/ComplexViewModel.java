package main.java.Interface_Adapters.ComplexCalculation;

import main.java.Interface_Adapters.ViewModel;

public class ComplexViewModel extends ViewModel<ComplexState> {

    public ComplexViewModel() {
        super("complex calculation");
        setState((new ComplexState()));
    }
}
