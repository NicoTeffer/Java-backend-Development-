package io.everyonecodes.practice2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CalculationSummaryTest {

    @Autowired
    CalculationSummary calculationSummary;

    @Test
    void calculationSummary() {
        var result = calculationSummary.calculationSummary();
        var expected = 45;
        Assertions.assertEquals(expected, result);
    }
}