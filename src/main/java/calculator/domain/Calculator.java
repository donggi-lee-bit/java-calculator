package calculator.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {

    public BigDecimal add(final BigDecimal num1, final BigDecimal num2) {
        return operationResultFormat(num1.add(num2));
    }

    public BigDecimal subtract(final BigDecimal num1, final BigDecimal num2) {
        return operationResultFormat(num1.subtract(num2));

    }

    public BigDecimal multiply(final BigDecimal num1, final BigDecimal num2) {
        return operationResultFormat(num1.multiply(num2));
    }

    public BigDecimal divide(final BigDecimal num1, final BigDecimal num2) {
        return num1.divide(num2, 1, RoundingMode.HALF_UP);
    }

    private BigDecimal operationResultFormat(BigDecimal result) {
        return result.setScale(1, RoundingMode.HALF_UP);
    }
}
