package calculator.controller;

import calculator.controller.view.InputView;
import calculator.controller.view.OutputView;
import calculator.domain.Operator;
import java.math.BigDecimal;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void execute() {
        while (true) {
            try {
                final String[] expression = inputView.readCalculationExpression();

                final BigDecimal operand1 = new BigDecimal(expression[0]);
                final Operator operator = Operator.fromSymbol(expression[1]);
                final BigDecimal operand2 = new BigDecimal(expression[2]);

                final BigDecimal result = operator.apply(operand1, operand2);

                outputView.displayResult(result);
            } catch (ArithmeticException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }

        }
    }
}
