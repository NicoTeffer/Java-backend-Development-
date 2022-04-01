package io.everyonecodes.practice2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SimpleCalculation2Test {

    @Autowired
    SimpleCalculation2 simpleCalculation2;

    @Test
    void calculation2() {
        var result = simpleCalculation2.calculation2();
        var expected = 20;
        Assertions.assertEquals(expected, result);
    }
}