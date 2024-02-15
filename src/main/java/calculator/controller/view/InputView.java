package calculator.controller.view;

import java.util.Scanner;

public class InputView {

    Scanner scanner = new Scanner(System.in);

    public String[] readCalculationExpression() {
        System.out.println("\n 계산할 식을 입력해주세요 (e. g. 10 + 10). 종료하려면 'q'를 입력하세요: ");
        String[] calculationExpression;
        try {
            calculationExpression = scanner.nextLine().trim().split(" ");
            validate(calculationExpression);
        } catch (IllegalArgumentException e) {
            System.err.println("[ERROR] " + e.getMessage());
            return readCalculationExpression();
        }
        return calculationExpression;
    }

    private void validate(final String[] calculationExpression) {
        if (calculationExpression.length != 3) {
            throw new IllegalArgumentException("입력 형식이 올바르지 않습니다.");
        }

        final String operand1 = calculationExpression[0];
        final String operation = calculationExpression[1];
        final String operand2 = calculationExpression[2];

        // 첫 번째 피연산자 유효성 검사
        if (!operand1.matches("[0-9]+[.]?[0-9]*")) {
            throw new IllegalArgumentException("첫 번째 피연산자가 숫자 형식이 아닙니다.");
        }

        // 연산자 유효성 검사
        if (!"+".equals(operation) && !"-".equals(operation) &&
            !"*".equals(operation) && !"/".equals(operation)) {
            throw new IllegalArgumentException("유효한 연산자가 아닙니다.");
        }

        // 두 번째 피연산자 유효성 검사
        if (!operand2.matches("[0-9]+[.]?[0-9]*")) {
            throw new IllegalArgumentException("두 번째 피연산자가 숫자 형식이 아닙니다.");
        }
    }
}
