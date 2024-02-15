package calculator;

import calculator.controller.validation.CalculationValidator;
import calculator.controller.view.InputView;
import calculator.controller.view.OutputView;
import calculator.domain.Calculator;
import java.math.BigDecimal;

public class Application {

    public static void main(String[] args){
        InputView inputView = new InputView(new CalculationValidator());
        Calculator calculator = new Calculator();
        OutputView outputView = new OutputView();

        while (true) {
            String[] expression = inputView.readCalculationExpression();
            BigDecimal result = runCalculation(calculator, expression);
            outputView.displayResult(result);
        }
    }

    private static BigDecimal runCalculation(Calculator calculator, String[] expression) {
        BigDecimal operand1 = new BigDecimal(expression[0]);
        String operator = expression[1];
        BigDecimal operand2 = new BigDecimal(expression[2]);

        switch (operator) {
            case "+":
                return calculator.add(operand1, operand2);
            case "-":
                return calculator.subtract(operand1, operand2);
            case "*":
                return calculator.multiply(operand1, operand2);
            case "/":
                return calculator.divide(operand1, operand2);
            default:
                throw new IllegalArgumentException("지원하지 않는 연산자입니다. " + operator);
        }
    }
}
