package io.everyonecodes.mysterious_calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MysteriousNumberCalculatorTest {

    @Autowired
    MysteriousNumberCalculator mysteriousNumberCalculator;

    @Test
    void calculate_1() {
        var result = mysteriousNumberCalculator.calculate(0);
        var expected = "The mysterious number is 3";
        Assertions.assertEquals(expected, result);
    }

    @Test
    void calculate_2() {
        var result = mysteriousNumberCalculator.calculate(1);
        var expected = "The mysterious number is 4";
        Assertions.assertEquals(expected, result);
    }

    @Test
    void calculate_3() {
        var result = mysteriousNumberCalculator.calculate(-1);
        var expected = "The mysterious number is 2";
        Assertions.assertEquals(expected, result);
    }
}