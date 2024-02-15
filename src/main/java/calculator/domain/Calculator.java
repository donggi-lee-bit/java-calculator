package calculator.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {

    public BigDecimal add(final BigDecimal num1, final BigDecimal num2) {
        return num1.add(num2)
            .setScale(1, RoundingMode.HALF_UP);
    }

    public BigDecimal subtract(final BigDecimal num1, final BigDecimal num2) {
        return num1.subtract(num2)
            .setScale(1, RoundingMode.HALF_UP);
    }

    public BigDecimal multiply(final BigDecimal num1, final BigDecimal num2) {
        return num1.multiply(num2)
            .setScale(1, RoundingMode.HALF_UP);
    }
}
