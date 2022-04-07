package io.everyonecodes.advanced_yml;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ChoiceTest {

    @Autowired
    Choice choice;

    @Test
    void isChoice() {
        var result = choice.getChoice();
        Assertions.assertFalse(result);
    }

    @Test
    void setChoice() {
        choice.setChoice(true);
        var result = choice.getChoice();
        Assertions.assertTrue(result);
    }
}