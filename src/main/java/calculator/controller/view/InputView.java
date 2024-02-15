package calculator.controller.view;

import calculator.controller.validation.Validator;
import java.util.Scanner;

public class InputView {

    public static final String EXIT_COMMAND = "q";

    private Validator validator;
    private Scanner scanner;

    public InputView(final Validator validator) {
        this.validator = validator;
        this.scanner = new Scanner(System.in);
    }

    public String[] readCalculationExpression() {
        System.out.println("\n계산할 식을 입력해주세요 (e. g. 10 + 10). 종료하려면 'q'를 입력하세요: ");
        String input = scanner.nextLine().trim();

        if (EXIT_COMMAND.equalsIgnoreCase(input)) {
            System.out.println("프로그램을 종료합니다.");
            System.exit(0);
        }

        final String[] calculationExpression = input.split(" ");

        try {
            validator.validate(calculationExpression);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return readCalculationExpression();
        }
        return calculationExpression;
    }
}
