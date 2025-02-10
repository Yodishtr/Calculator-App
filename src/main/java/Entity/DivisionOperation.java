package Entity;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Entity representing Division Operation
 */
public class DivisionOperation implements Operation {

    @Override
    public Numbers execute(Numbers num1, Numbers num2) {
        BigDecimal a = num1.getValue();
        BigDecimal b = num2.getValue();
        if (b.equals(BigDecimal.ZERO)){
            throw new ArithmeticException("Division by zero is not allowed");
        }
        BigDecimal result = a.divide(b, 10, RoundingMode.HALF_UP);
        String quotient = result.toString();
        return new Numbers(quotient);
    }
}
