package main.java.Entity;

import java.math.BigDecimal;

/**
 * Entity representing Division Operation
 */
public class DivisionOperation implements Operation {

    @Override
    public Numbers execute(Numbers num1, Numbers num2) {
        BigDecimal a = num1.getValue();
        BigDecimal b = num2.getValue();
        BigDecimal result = a.divide(b);
        String quotient = result.toString();
        return new Numbers(quotient);
    }
}
