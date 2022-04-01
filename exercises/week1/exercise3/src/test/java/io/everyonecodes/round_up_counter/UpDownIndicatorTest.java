package io.everyonecodes.round_up_counter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UpDownIndicatorTest {

    @Autowired
    UpDownIndicator upDownIndicator;

    @Test
    void indicate_SAME() {
        var result = upDownIndicator.indicate(1.5);
        var expected = "SAME";
        Assertions.assertEquals(expected, result);
    }

    @Test
    void indicate_UP() {
        var result = upDownIndicator.indicate(1.7);
        var expected = "UP";
        Assertions.assertEquals(expected, result);
    }

    @Test
    void indicate_DOWN() {
        var result = upDownIndicator.indicate(1.3);
        var expected = "DOWN";
        Assertions.assertEquals(expected, result);
    }
}