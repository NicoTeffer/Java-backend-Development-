package io.everyonecodes.basic_properties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class ChoiceTest {

    @Autowired
    Choice choice;

    @Test
    void getChoice() {
        var result = choice.getChoice();
        Assertions.assertTrue(result);
    }
}