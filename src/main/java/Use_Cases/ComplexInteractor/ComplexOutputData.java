package main.java.Use_Cases.ComplexInteractor;

import java.math.BigDecimal;

/**
 * Output data for complex calculation use case
 */
public class ComplexOutputData {
    private final BigDecimal numericalValue;
    private final String wordValue;
    private final String expression;
    private boolean usecaseFailed;

    public ComplexOutputData(BigDecimal numericalValue, String wordValue, String expression, boolean usecaseFailed) {
        this.numericalValue = numericalValue;
        this.wordValue = wordValue;
        this.usecaseFailed = usecaseFailed;
        this.expression = expression;
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
}
