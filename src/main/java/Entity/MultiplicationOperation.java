package Entity;

import java.math.BigDecimal;

/**
 * Entity representing Multiplication Operation
 */
public class MultiplicationOperation implements Operation {

    @Override
    public Numbers execute(Numbers num1, Numbers num2) {
        BigDecimal a = num1.getValue();
        BigDecimal b = num2.getValue();
        BigDecimal result = a.multiply(b);
        String product = result.toString();
        return new Numbers(product);
    }
}
