package skypro.com.springhomework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CalculatorServiceTest {

    private CalculatorService out;

    @BeforeEach
    public void init() {
        this.out = new CalculatorService();
    }

    @Test
    public void testSum() {
        int result = out.sum(1, 2);
         assertEquals(3, result);
    }

    @Test
    public void testSumWithZero() {
        int result = out.sum(3, 0);
        assertEquals(3, result);
    }

    @Test
    public void testMinus() {
        int result = out.minus(5, 4);
        assertEquals(1, result);
    }

    @Test
    public void testMinusWithNegativeResult() {
        int result = out.minus(4, 5);
        assertEquals(-1, result);
    }

    @Test
    public void testMultiply() {
        int result = out.multiply(6, 7);
        assertEquals(42, result);
    }

    @Test
    public void testMultiplyOnZero() {
        int result = out.multiply(8, 0);
        assertEquals(0, result);
    }

    @Test
    public void testDivision() {
        int result = out.division(9, 3);
        assertEquals(3, result);
    }

    @Test
    public void testDivisionZeroFirstNum() {
        int result = out.division(0, 10);
        assertEquals(0, result);
    }

    @Test
    public void testDivisionZeroSecondNum() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> out.division(11, 0));
    }

    private static Stream<Arguments> sumTestParams() {
        return Stream.of(
                Arguments.of(1, 9, 10),
                Arguments.of(0, 8, 8),
                Arguments.of(10, -5, 5));
    }

    private static Stream<Arguments> minusTestParams() {
        return Stream.of(
                Arguments.of(10, 6, 4),
                Arguments.of(10, 0, 10),
                Arguments.of(6, 16, -10));
    }

    private static Stream<Arguments> multiplyTestParams() {
        return Stream.of(
                Arguments.of(5, 5, 25),
                Arguments.of(8, 0, 0),
                Arguments.of(-3, 6, -18));
    }

    private static Stream<Arguments> divisionTestParams() {
        return Stream.of(
                Arguments.of(8, 4, 2),
                Arguments.of(0, 11, 0),
                Arguments.of(10, 15, 0));
    }

    @ParameterizedTest
    @MethodSource("sumTestParams")
    public void paramSumTest(int num1, int num2, int expectedResult) {
        assertEquals(expectedResult, out.sum(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("minusTestParams")
    public void paramMinusTest(int num1, int num2, int expectedResult) {
        assertEquals(expectedResult, out.minus(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("multiplyTestParams")
    public void paramMultiplyTest(int num1, int num2, int expectedResult) {
        assertEquals(expectedResult, out.multiply(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("divisionTestParams")
    public void paramDivisionTest(int num1, int num2, int expectedResult) {
        assertEquals(expectedResult, out.division(num1, num2));
    }

}
