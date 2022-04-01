package io.everyonecodes.amazing_goodbye_world;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AmazingGoodbyeWorldTest {

    @Autowired
    AmazingGoodbyeWorld amazingGoodbyeWorld;

    @Test
    void get() {
        var result = amazingGoodbyeWorld.get();
        var expected = "Goodbye World";
        Assertions.assertEquals(expected, result);
    }
}