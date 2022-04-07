package io.everyonecodes.basic_properties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SeveralValuesTest {

    @Autowired
    SeveralValues severalValues;

    @Test
    void getNumbers() {
        var result = severalValues.getNumbers();
        var expected = List.of(2, 4, 6, 8);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void getDecimalNumbers() {
        var result = severalValues.getDecimalNumbers();
        var expected = List.of(2.2, 4.4, 6.6, 8.8);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void getWords() {
        var result = severalValues.getWords();
        var expected = List.of("these", "are", "several", "words");
        Assertions.assertEquals(expected, result);
    }

    @Test
    void getChoices() {
        var result = severalValues.getChoices();
        var expected = List.of(true, false, false, true);
        Assertions.assertEquals(expected, result);
    }
}