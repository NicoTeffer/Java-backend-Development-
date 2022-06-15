package io.everyonecodes.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolationException;

@SpringBootTest
class TextServiceTest {

    @Autowired
    TextService textService;

    @Test
    void getText() {
        Text text = new Text("test");
        var result = textService.getText(text);
        Assertions.assertEquals(text,result);
    }

    @Test
    void doNotGetText() {
        Text text = new Text("te");
        Assertions.assertThrows(ConstraintViolationException.class, () -> textService.getText(text));
    }
}