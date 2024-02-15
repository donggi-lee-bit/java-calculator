package calculator.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
public class OperatorTest {

    @ParameterizedTest
    @MethodSource("provideNumbersForAddition")
    void 덧셈_연산_성공(BigDecimal num1, BigDecimal num2, BigDecimal expected) {
        assertEquals(expected, Operator.ADD.apply(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("provideNumbersForSubtraction")
    void 뺄셈_연산_성공(BigDecimal num1, BigDecimal num2, BigDecimal expected) {
        assertEquals(expected, Operator.SUBTRACT.apply(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("provideNumbersForMultiplication")
    void 곱셈_연산_성공(BigDecimal num1, BigDecimal num2, BigDecimal expected) {
        assertEquals(expected, Operator.MULTIPLY.apply(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("provideNumbersForDivision")
    void 나눗셈_연산_성공(BigDecimal num1, BigDecimal num2, BigDecimal expected) {
        assertEquals(expected, Operator.DIVIDE.apply(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("provideNumbersForDivisionByZero")
    void 나눗셈_0으로_나누는_경우_예외_발생(BigDecimal num1, BigDecimal num2) {
        assertThrows(ArithmeticException.class, () -> Operator.DIVIDE.apply(num1, num2));
    }

    private static Stream<Arguments> provideNumbersForAddition() {
        return Stream.of(
            Arguments.of(new BigDecimal("1.2"), new BigDecimal("2.3"), new BigDecimal("3.5")),
            Arguments.of(new BigDecimal("2.3"), new BigDecimal("3.4"), new BigDecimal("5.7")),
            Arguments.of(new BigDecimal("10.1"), new BigDecimal("2"), new BigDecimal("12.1")),
            Arguments.of(new BigDecimal("1"), new BigDecimal("2"), new BigDecimal("3")),
            Arguments.of(new BigDecimal("2"), new BigDecimal("3"), new BigDecimal("5")),
            Arguments.of(new BigDecimal("10"), new BigDecimal("20"), new BigDecimal("30")),
            Arguments.of(new BigDecimal("0.1"), new BigDecimal("0.2"), new BigDecimal("0.3")),
            Arguments.of(new BigDecimal("0.5"), new BigDecimal("0.4"), new BigDecimal("0.9"))
        );
    }

    private static Stream<Arguments> provideNumbersForSubtraction() {
        return Stream.of(
            Arguments.of(new BigDecimal("3.5"), new BigDecimal("2.3"), new BigDecimal("1.2")),
            Arguments.of(new BigDecimal("5.7"), new BigDecimal("3.4"), new BigDecimal("2.3")),
            Arguments.of(new BigDecimal("12.1"), new BigDecimal("2.0"), new BigDecimal("10.1")),
            Arguments.of(new BigDecimal("3.0"), new BigDecimal("2.0"), new BigDecimal("1.0")),
            Arguments.of(new BigDecimal("5.0"), new BigDecimal("3.0"), new BigDecimal("2.0")),
            Arguments.of(new BigDecimal("30.0"), new BigDecimal("20.0"), new BigDecimal("10.0")),
            Arguments.of(new BigDecimal("0.2"), new BigDecimal("0.1"), new BigDecimal("0.1")),
            Arguments.of(new BigDecimal("0.5"), new BigDecimal("0.4"), new BigDecimal("0.1"))
        );
    }

    private static Stream<Arguments> provideNumbersForMultiplication() {
        return Stream.of(
            Arguments.of(new BigDecimal("1.2"), new BigDecimal("2.3"), new BigDecimal("2.8")),
            Arguments.of(new BigDecimal("2.3"), new BigDecimal("3.4"), new BigDecimal("7.8")),
            Arguments.of(new BigDecimal("10.1"), new BigDecimal("2.0"), new BigDecimal("20.2")),
            Arguments.of(new BigDecimal("1.0"), new BigDecimal("2.0"), new BigDecimal("2.0")),
            Arguments.of(new BigDecimal("2.0"), new BigDecimal("3.0"), new BigDecimal("6.0")),
            Arguments.of(new BigDecimal("10.0"), new BigDecimal("20.0"), new BigDecimal("200.0")),
            Arguments.of(new BigDecimal("0.2"), new BigDecimal("0.1"), new BigDecimal("0.0")),
            Arguments.of(new BigDecimal("0.5"), new BigDecimal("0.4"), new BigDecimal("0.2"))
        );
    }

    private static Stream<Arguments> provideNumbersForDivision() {
        return Stream.of(
            Arguments.of(new BigDecimal("3.5"), new BigDecimal("2.3"), new BigDecimal("1.5")),
            Arguments.of(new BigDecimal("5.7"), new BigDecimal("3.4"), new BigDecimal("1.7")),
            Arguments.of(new BigDecimal("12.1"), new BigDecimal("2.0"), new BigDecimal("6.1")),
            Arguments.of(new BigDecimal("3.0"), new BigDecimal("2.0"), new BigDecimal("1.5")),
            Arguments.of(new BigDecimal("5.0"), new BigDecimal("3.0"), new BigDecimal("1.7")),
            Arguments.of(new BigDecimal("30.0"), new BigDecimal("20.0"), new BigDecimal("1.5"))
        );
    }

    private static Stream<Arguments> provideNumbersForDivisionByZero() {
        return Stream.of(
            Arguments.of(new BigDecimal("3.5"), BigDecimal.ZERO),
            Arguments.of(new BigDecimal("5.7"), BigDecimal.ZERO),
            Arguments.of(new BigDecimal("12.1"), BigDecimal.ZERO),
            Arguments.of(new BigDecimal("3.0"), BigDecimal.ZERO),
            Arguments.of(new BigDecimal("5.0"), BigDecimal.ZERO),
            Arguments.of(new BigDecimal("30.0"), BigDecimal.ZERO)
        );
    }
}
