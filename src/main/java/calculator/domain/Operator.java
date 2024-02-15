package calculator.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum Operator {
    ADD("+") {
        @Override
        public BigDecimal apply(BigDecimal operand1, BigDecimal operand2) {
            return operand1.add(operand2);
        }
    },
    SUBTRACT("-") {
        @Override
        public BigDecimal apply(BigDecimal operand1, BigDecimal operand2) {
            return operand1.subtract(operand2);
        }
    },
    MULTIPLY("*") {
        @Override
        public BigDecimal apply(BigDecimal operand1, BigDecimal operand2) {
            return operand1.multiply(operand2).setScale(1, RoundingMode.HALF_UP);
        }
    },
    DIVIDE("/") {
        @Override
        public BigDecimal apply(BigDecimal operand1, BigDecimal operand2) {
            // 0으로 나눌 시 예외 반환
            if (BigDecimal.ZERO.equals(operand2)) {
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            }
            return operand1.divide(operand2, 1, RoundingMode.HALF_UP);
        }
    };

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public abstract BigDecimal apply(BigDecimal operand1, BigDecimal operand2);

    public static Operator fromSymbol(String symbol) {
        for (Operator operator : values()) {
            if (operator.symbol.equals(symbol)) {
                return operator;
            }
        }

        throw new IllegalArgumentException("지원하지 않는 연산자입니다. : " + symbol);
    }
}
