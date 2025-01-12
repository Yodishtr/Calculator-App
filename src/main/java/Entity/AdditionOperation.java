package main.java.Entity;

import java.math.BigDecimal;

/**
 * Entity class responsible for addition operation
 */
public class AdditionOperation implements Operation {

    @Override
    public Numbers execute(Numbers num1, Numbers num2) {
        BigDecimal a = num1.getValue();
        BigDecimal b = num2.getValue();
        BigDecimal sum = a.add(b);
        String result = sum.toString();
        return new Numbers(result);
    }
}
