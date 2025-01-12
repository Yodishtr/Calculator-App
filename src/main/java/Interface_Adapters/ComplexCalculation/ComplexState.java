package main.java.Interface_Adapters.ComplexCalculation;

/**
 * State for complex view model
 */
public class ComplexState {
    private String expressionToCalculate;
    private String expressionToDisplay;
    private boolean isResultDisplayed;

    public ComplexState(String expressionToCalculate, String expressionToDisplay, boolean isResultDisplayed) {
        this.expressionToCalculate = expressionToCalculate;
        this.expressionToDisplay = expressionToDisplay;
        this.isResultDisplayed = isResultDisplayed;
    }

    public ComplexState(){
        this.expressionToCalculate = "";
        this.expressionToDisplay = "";
        this.isResultDisplayed = false;
    }

    public String getExpressionToCalculate() {
        return expressionToCalculate;
    }

    public void setExpressionToCalculate(String expressionToCalculate) {
        this.expressionToCalculate = expressionToCalculate;
    }

    public String getExpressionToDisplay() {
        return expressionToDisplay;
    }

    public void setExpressionToDisplay(String expressionToDisplay) {
        this.expressionToDisplay = expressionToDisplay;
    }

    public boolean getIsResultDisplayed() {
        return isResultDisplayed;
    }

    public void setIsResultDisplayed(boolean isResultDisplayed) {
        this.isResultDisplayed = isResultDisplayed;
    }

}
