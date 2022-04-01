package io.everyonecodes.round_up_counter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class RounderTest {

    @Autowired
    Rounder rounder;

    @Test
    void roundUp() {
        double number = 1.5;
        var result = rounder.roundUp(number);
        var expected = 2.0;
        Assertions.assertEquals(expected, result);
    }

    @Test
    void roundDown() {
        double number = 1.5;
        var result = rounder.roundDown(number);
        var expected = 1.0;
        Assertions.assertEquals(expected, result);
    }
}