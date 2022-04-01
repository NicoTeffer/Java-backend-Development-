package io.everyonecodes.round_up_counter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
class UpCounterTest {

    @Autowired
    UpCounter upCounter;

    @Test
    void count() {
        List<Double> doubleList = List.of(2.0,1.0,1.5,2.0,1.5,2.5,3.0,1.5,2.0);
        var result = upCounter.count(doubleList);
        var expected = 3;
        Assertions.assertEquals(expected, result);
    }
}