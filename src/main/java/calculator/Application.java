package calculator;

import calculator.controller.validation.CalculationValidator;
import calculator.controller.view.InputView;
import calculator.controller.view.OutputView;
import calculator.domain.Operator;
import java.math.BigDecimal;

public class Application {

    public static void main(String[] args){
        InputView inputView = new InputView(new CalculationValidator());
        OutputView outputView = new OutputView();

        while (true) {
            try {
                String[] expression = inputView.readCalculationExpression();

                BigDecimal operand1 = new BigDecimal(expression[0]);
                Operator operator = Operator.fromSymbol(expression[1]);
                BigDecimal operand2 = new BigDecimal(expression[2]);

                BigDecimal result = operator.apply(operand1, operand2);

                outputView.displayResult(result);
            } catch (ArithmeticException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }

        }
    }
}
