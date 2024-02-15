package calculator.controller.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class CalculationValidatorTest {

    private CalculationValidator validator;

    @BeforeEach
    void setUp() {
        validator = new CalculationValidator();
    }

    @Test
    void 올바른_입력_형식의_경우_예외를_발생시키지_않는다() {
        // given
        String[] validExpression = {"3.5", "*", "1.5"};

        // when & then
        assertDoesNotThrow(() -> validator.validate(validExpression));
    }

    @Test
    void 피연산자가_숫자_형식이_아닌_경우_예외을_발생시킨다() {
        // given
        String[] invalidOperandExpression = {"a", "+", "2"};

        // when & then
        assertThrows(IllegalArgumentException.class, () -> validator.validate(invalidOperandExpression));
    }

    @Test
    void 유효하지_않은_연산자인_경우_예외를_발생시킨다() {
        // given
        String[] invalidOperatorExpression = {"2", "^", "2"};

        // when & then
        assertThrows(IllegalArgumentException.class, () -> validator.validate(invalidOperatorExpression));
    }

    @Test
    void 입력_형식의_길이가_올바르지_않은_경우_예외를_발생시킨다() {
        // given
        String[] invalidLengthExpression = {"2", "+"};

        // when & then
        assertThrows(IllegalArgumentException.class, () -> validator.validate(invalidLengthExpression));
    }
}