package io.everyoncecodes.practice3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SimpleCalculationTest {

    @Autowired
    SimpleCalculation simpleCalculation;

    @Test
    void calculation() {
        var result = simpleCalculation.calculation();
        var expected = 20;
        Assertions.assertEquals(expected, result);
    }
}