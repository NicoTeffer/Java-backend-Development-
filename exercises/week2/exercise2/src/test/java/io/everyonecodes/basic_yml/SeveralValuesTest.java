package io.everyonecodes.basic_yml;

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
        var expected = List.of(5, 10, 15, 20, 25);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void getDecimalNumbers() {
        var result = severalValues.getDecimalNumbers();
        var expected = List.of(2.2, 4.4, 6.6, 8.8, 10.10);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void getWords() {
        var result = severalValues.getWords();
        var expected = List.of("These", "are", "several", "basic", "words", "(YAML)");
        Assertions.assertEquals(expected, result);
    }

    @Test
    void getChoices() {
        var result = severalValues.getChoices();
        var expected = List.of(false, true, true, false);
        Assertions.assertEquals(expected, result);
    }
}