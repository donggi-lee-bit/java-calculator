package calculator.controller.view;

import calculator.controller.validation.Validator;
import java.util.Scanner;

public class InputView {

    private Validator validator;
    private Scanner scanner;

    public InputView(final Validator validator) {
        this.validator = validator;
        this.scanner = new Scanner(System.in);
    }

    public String[] readCalculationExpression() {
        System.out.println("\n 계산할 식을 입력해주세요 (e. g. 10 + 10). 종료하려면 'q'를 입력하세요: ");
        String[] calculationExpression;
        try {
            calculationExpression = scanner.nextLine().trim().split(" ");
            validator.validate(calculationExpression);
        } catch (IllegalArgumentException e) {
            System.err.println("[ERROR] " + e.getMessage());
            return readCalculationExpression();
        }
        return calculationExpression;
    }
}
