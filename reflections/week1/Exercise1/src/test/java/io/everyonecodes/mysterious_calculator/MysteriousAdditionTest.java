package io.everyonecodes.mysterious_calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MysteriousAdditionTest {

    MysteriousAddition mysteriousAddition = new MysteriousAddition(1);

    @Test
    void apply_1() {
        var result = mysteriousAddition.apply(1);
        var expected = 2;
        Assertions.assertEquals(expected, result);
    }

    @Test
    void apply_2() {
        var result = mysteriousAddition.apply(3);
        var expected = 4;
        Assertions.assertEquals(expected, result);
    }

    @Test
    void apply_3() {
        var result = mysteriousAddition.apply(12);
        var expected = 13;
        Assertions.assertEquals(expected, result);
    }
}