package calculator.controller.view;

import java.math.BigDecimal;

public class OutputView {

    public void displayResult(final BigDecimal result) {
        System.out.println("\n계산 결과: " + result.stripTrailingZeros().toPlainString());
    }
}
