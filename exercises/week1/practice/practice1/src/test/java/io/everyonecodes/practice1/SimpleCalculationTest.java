package io.everyonecodes.practice1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class SimpleCalculationTest {

    @Autowired
    SimpleCalculation simpleCalculation;

    @Test
    void calculation() {
        var result = simpleCalculation.calculation();
        var expected = 25;
        Assertions.assertEquals(expected, result);
    }
}