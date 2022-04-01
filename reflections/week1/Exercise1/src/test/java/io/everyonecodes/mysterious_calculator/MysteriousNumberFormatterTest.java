package io.everyonecodes.mysterious_calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MysteriousNumberFormatterTest {

    MysteriousNumberFormatter mysteriousNumberFormatter =
            new MysteriousNumberFormatter();

    @Test
    void format() {
        var result = mysteriousNumberFormatter.format(1);
        var expected = "The mysterious number is 1";
        Assertions.assertEquals(expected, result);
    }
}