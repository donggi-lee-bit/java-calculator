package calculator.domain;

import calculator.domain.config.PrecisionConfiguration;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {

    private final PrecisionConfiguration precisionConfig;

    public Calculator(final PrecisionConfiguration precisionConfig) {
        this.precisionConfig = precisionConfig;
    }

    public BigDecimal calculate(String operatorSymbol, BigDecimal operand1, BigDecimal operand2) {
        switch (Operator.fromSymbol(operatorSymbol)) {
            case ADD:
                return operand1.add(operand2);
            case SUBTRACT:
                return operand1.subtract(operand2);
            case MULTIPLY:
                return operand1.multiply(operand2);
            case DIVIDE:
                if (BigDecimal.ZERO.equals(operand2)) {
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }

                return operand1.divide(operand2, precisionConfig.getPrecision(), RoundingMode.HALF_UP);
            default:
                throw new IllegalArgumentException("지원하지 않는 연산자입니다: " + operatorSymbol);
        }
    }
}
