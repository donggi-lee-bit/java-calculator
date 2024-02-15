package calculator.controller.validation;

public class CalculationValidator implements Validator {

    public static final String OPERAND_REGEX = "[0-9]+[.]?[0-9]*";
    public static final int VALID_EXPRESSION_LENGTH = 3;

    @Override
    public void validate(final String[] expression) {
        if (expression.length != VALID_EXPRESSION_LENGTH) {
            throw new IllegalArgumentException("입력 형식이 올바르지 않습니다.");
        }

        if (!expression[0].matches(OPERAND_REGEX) || !expression[2].matches(OPERAND_REGEX)) {
            throw new IllegalArgumentException("피연산자가 숫자 형식이 아닙니다.");
        }

        String operation = expression[1];
        if (!"+".equals(operation) && !"-".equals(operation) &&
            !"*".equals(operation) && !"/".equals(operation)) {
            throw new IllegalArgumentException("유효한 연산자가 아닙니다.");
        }
    }
}
