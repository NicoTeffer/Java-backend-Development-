package io.everyonecodes.advanced_yml;

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
    void getNaturalNumbers() {
        var result = severalValues.getNaturalNumbers();
        var expected = List.of(5, 10, 15, 20, 25);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void setNaturalNumbers() {
        severalValues.setNaturalNumbers(List.of(1, 2, 3, 4, 5));
        var result = severalValues.getNaturalNumbers();
        var expected = List.of(1, 2, 3, 4, 5);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void getDecimalNumbers() {
        var result = severalValues.getDecimalNumbers();
        var expected = List.of(2.2, 4.4, 6.6, 8.8, 10.10);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void setDecimalNumbers() {
        severalValues.setDecimalNumbers(List.of(1.1, 2.2, 3.3, 4.4, 5.5));
        var result = severalValues.getDecimalNumbers();
        var expected = List.of(1.1, 2.2, 3.3, 4.4, 5.5);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void getWords() {
        var result = severalValues.getWords();
        var expected = List.of("These", "are", "several", "basic", "words", "(advanced YAML)");
        Assertions.assertEquals(expected, result);
    }

    @Test
    void setWords() {
        severalValues.setWords(List.of("One", "Two", "Three"));
        var result = severalValues.getWords();
        var expected = List.of("One", "Two", "Three");
        Assertions.assertEquals(expected, result);
    }

    @Test
    void getChoices() {
        var result = severalValues.getChoices();
        var expected = List.of(false, true, true, false);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void setChoices() {
        severalValues.setChoices(List.of(false, true, true, true));
        var result = severalValues.getChoices();
        var expected = List.of(false, true, true, true);
        Assertions.assertEquals(expected, result);
    }
}