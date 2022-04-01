package io.everyonecodes.goodbye_world;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GoodbyeWorldTest {

    @Autowired
    GoodbyeWorld goodbyeWorld;

    @Test
    void get() {
        var result = goodbyeWorld.get();
        var expected = "Goodbye World";
        Assertions.assertEquals(expected, result);
    }
}