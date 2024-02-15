package calculator;

import calculator.controller.validation.CalculationValidator;
import calculator.controller.view.InputView;

public class Application {

    public static void main(String[] args){
        InputView inputView = new InputView(new CalculationValidator());

        while (true) {
            String[] expression = inputView.readCalculationExpression();
        }
    }
}
