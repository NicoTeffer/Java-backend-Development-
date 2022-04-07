package io.everyonecodes.basic_yml;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class MessageTest {

    @Autowired
    Message message;

    @Test
    void getMessage() {
        var result = message.getMessage();
        var expected = "This is a basic message(YML)";
        Assertions.assertEquals(expected, result);
    }
}