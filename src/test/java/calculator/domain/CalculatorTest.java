package calculator.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
public class CalculatorTest {

    @ParameterizedTest
    @CsvSource({"1,2,3", "2,3,5", "10,20,30"})
    void 덧셈이_성공하면_덧셈_결과를_반환한다(int num1, int num2, int expected) {
        Calculator calculator = new Calculator();

        int actual = calculator.add(num1, num2);

        assertEquals(expected, actual);
    }
}
