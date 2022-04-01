package io.everyonecodes.amazing_goodbye_world;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GoodbyeTest {

    @Autowired
    Goodbye goodbye;

    @Test
    void get() {
        var result = goodbye.get();
        var expected = "Goodbye";
        Assertions.assertEquals(expected, result);
    }
}