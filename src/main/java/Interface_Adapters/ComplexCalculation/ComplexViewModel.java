package Interface_Adapters.ComplexCalculation;

import Interface_Adapters.ViewModel;

public class ComplexViewModel extends ViewModel<ComplexState> {

    public ComplexViewModel() {
        super("calculator");
        setState((new ComplexState()));
    }
}
