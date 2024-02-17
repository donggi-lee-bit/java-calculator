package calculator.controller;

import calculator.controller.view.InputView;
import calculator.controller.view.OutputView;
import calculator.domain.Calculator;
import calculator.domain.config.PrecisionConfiguration;
import java.math.BigDecimal;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Calculator calculator;

    public CalculatorController(
        final InputView inputView,
        final OutputView outputView,
        final PrecisionConfiguration precisionConfiguration
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculator = new Calculator(precisionConfiguration);
    }

    public void execute() {
        while (true) {
            try {
                final String[] expression = inputView.readCalculationExpression();

                final BigDecimal operand1 = new BigDecimal(expression[0]);
                final String operatorSymbol = expression[1];
                final BigDecimal operand2 = new BigDecimal(expression[2]);

                final BigDecimal result = calculator.calculate(operatorSymbol, operand1, operand2);

                outputView.displayResult(result);
            } catch (ArithmeticException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }

        }
    }
}
