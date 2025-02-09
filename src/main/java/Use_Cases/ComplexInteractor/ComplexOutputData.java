package Use_Cases.ComplexInteractor;

import java.math.BigDecimal;

/**
 * Output data for complex calculation use case
 */
public class ComplexOutputData {
    private final BigDecimal numericalValue;
    private final String wordValue;
    private String expressionInput;
    private boolean usecaseFailed;

    public ComplexOutputData(BigDecimal numericalValue, String wordValue, String expressionInput, boolean usecaseFailed) {
        this.numericalValue = numericalValue;
        this.wordValue = wordValue;
        this.usecaseFailed = usecaseFailed;
        this.expressionInput = expressionInput;
    }

    public BigDecimal getNumericalValue() {
        return numericalValue;
    }

    public String getWordValue() {
        return wordValue;
    }

    public boolean isUsecaseFailed() {
        return usecaseFailed;
    }

    public void setUsecaseFailed(boolean usecaseFailed) {
        this.usecaseFailed = usecaseFailed;
    }

    public String getExpressionInput() {
        return expressionInput;
    }

    public void setExpressionInput(String expression) {
        this.expressionInput = expression;
    }
}
