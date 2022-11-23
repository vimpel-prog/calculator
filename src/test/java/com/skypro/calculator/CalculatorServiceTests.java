package com.skypro.calculator;

import com.skypro.calculator.Exception.IllegalNumberException;
import com.skypro.calculator.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorServiceTests {
    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    public void divideByZeroThrowsException(){
       assertThrows(IllegalNumberException.class,()->calculatorService.getDivide(5,0));
    }
    @Test
    public void plusTest() {
        int num1 = 7;
        int num2 = 10;
        int result = 17;

        assertEquals(result, calculatorService.getSum(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForPlusTest")
    public void plusTest(int num1, int num2, int result) {
        assertEquals(result, calculatorService.getSum(num1, num2));
    }
    @ParameterizedTest
    @MethodSource("provideParamsForMinusTest")
    public void minusTest(int num1, int num2, int result) {
        assertEquals(result, calculatorService.getMinus(num1, num2));
    }
    @ParameterizedTest
    @MethodSource("provideParamsForMultiplyTest")
    public void multiplyTest(int num1, int num2, int result) {
        assertEquals(result, calculatorService.getMultiply(num1, num2));
    }
    @ParameterizedTest
    @MethodSource("provideParamsForDivideTest")
    public void divideTest(int num1, int num2, int result) {
        assertEquals(result, calculatorService.getDivide(num1, num2));
    }

    public static List<Arguments> provideParamsForPlusTest() {
        return List.of(
                Arguments.of(3, 5, 8),
                Arguments.of(6, 3, 9),
                Arguments.of(12, 13, 25),
                Arguments.of(0, 0, 0)
        );
    }

    public static List<Arguments> provideParamsForMinusTest() {
        return List.of(
                Arguments.of(3, 5, -2),
                Arguments.of(6, 3, 3),
                Arguments.of(12, 13, -1),
                Arguments.of(0, 0, 0)
        );
    }

    public static List<Arguments> provideParamsForMultiplyTest() {
        return List.of(
                Arguments.of(3, 5, 15),
                Arguments.of(6, 3, 18),
                Arguments.of(12, 13, 156),
                Arguments.of(0, 25, 0)
        );
    }

    public static List<Arguments> provideParamsForDivideTest() {
        return List.of(
                Arguments.of(8, 4, 2),
                Arguments.of(6, 3, 2),
                Arguments.of(12, 12, 1),
                Arguments.of(0, 1, 0)
        );
    }
}
