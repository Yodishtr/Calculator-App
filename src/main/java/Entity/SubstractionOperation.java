package main.java.Entity;

import java.math.BigDecimal;

/**
 * Entity class representing Substraction
 */
public class SubstractionOperation implements Operation {

    @Override
    public Numbers execute(Numbers num1, Numbers num2) {
        BigDecimal a = num1.getValue();
        BigDecimal b = num2.getValue();
        BigDecimal result = a.subtract(b);
        String difference = result.toString();
        return new Numbers(difference);
    }
}
