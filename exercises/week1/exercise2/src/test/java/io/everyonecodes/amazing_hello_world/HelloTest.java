package io.everyonecodes.amazing_hello_world;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloTest {

    @Autowired
    Hello hello;

    @Test
    void get() {
        var result = hello.get();
        var expected = "Hello";
        Assertions.assertEquals(expected, result);
    }
}