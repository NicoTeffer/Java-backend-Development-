package io.everyonecodes.amazing_hello_world;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class WorldTest {

    @Autowired
    World world;

    @Test
    void get() {
        var result = world.get();
        var expected = "World";
        Assertions.assertEquals(expected, result);
    }
}