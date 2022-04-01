package io.everyonecodes.amazing_hello_world;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class AmazingHelloWorldTest {

    @Autowired
    AmazingHelloWorld amazingHelloWorld;

    @Test
    void get() {
        var result = amazingHelloWorld.get();
        var expected = "Hello World";
        Assertions.assertEquals(expected, result);
    }
}