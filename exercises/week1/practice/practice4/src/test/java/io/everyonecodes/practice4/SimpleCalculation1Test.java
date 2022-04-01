package io.everyonecodes.practice4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SimpleCalculation1Test {

    @Autowired
    SimpleCalculation1 simpleCalculation1;

    @Test
    void calculation1() {
        var result = simpleCalculation1.calculation1();
        var expected = 25;
        Assertions.assertEquals(expected, result);
    }
}