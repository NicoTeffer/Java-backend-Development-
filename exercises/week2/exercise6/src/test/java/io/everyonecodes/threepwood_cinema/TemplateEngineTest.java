package io.everyonecodes.threepwood_cinema;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TemplateEngineTest {

    @Autowired
    TemplateEngine templateEngine;

    @Test
    void defaultMessage() {
        var result = templateEngine.customiseMessage("TestName");
        var expected = "Hello TestName!";
        Assertions.assertEquals(expected,result);
    }
}