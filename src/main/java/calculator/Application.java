package calculator;

import calculator.controller.CalculatorController;
import calculator.controller.validation.CalculationValidator;
import calculator.controller.view.InputView;
import calculator.controller.view.OutputView;

public class Application {

    public static void main(String[] args){
        final InputView inputView = new InputView(new CalculationValidator());
        final OutputView outputView = new OutputView();

        final CalculatorController calculatorController = new CalculatorController(inputView, outputView);
        calculatorController.execute();
    }
}
