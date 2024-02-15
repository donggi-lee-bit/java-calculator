package calculator.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
public class CalculatorTest {

    @ParameterizedTest
    @MethodSource("provideNumbersForAddition")
    void 덧셈이_성공하면_덧셈_결과를_반환한다(BigDecimal num1, BigDecimal num2, BigDecimal expected) {
        Calculator calculator = new Calculator();

        BigDecimal actual = calculator.add(num1, num2);

        assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideNumbersForAddition() {
        return Stream.of(
            Arguments.of(new BigDecimal("1.2"), new BigDecimal("2.3"), new BigDecimal("3.5")),
            Arguments.of(new BigDecimal("2.3"), new BigDecimal("3.4"), new BigDecimal("5.7")),
            Arguments.of(new BigDecimal("10.1"), new BigDecimal("2"), new BigDecimal("12.1")),
            Arguments.of(new BigDecimal("1"), new BigDecimal("2"), new BigDecimal("3.0")),
            Arguments.of(new BigDecimal("2"), new BigDecimal("3"), new BigDecimal("5.0")),
            Arguments.of(new BigDecimal("10"), new BigDecimal("20"), new BigDecimal("30.0"))
        );
    }
}
