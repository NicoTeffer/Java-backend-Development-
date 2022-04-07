package io.everyonecodes.threepwood_cinema;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TemplateMessageFinderTest {

    @Autowired
    TemplateMessageFinder templateMessageFinder;

    @ParameterizedTest
    @CsvSource({
            "Mr. James Hetfield, Good day --name--",
            "Mrs. Alanah Pierce, Dear --name--",
            "James Threepwood, My dearest --name--",
            "Super Mario, Hello --name--!"
    })
    void find(String input, String expected) {
        var result = templateMessageFinder.find(input);
        Assertions.assertEquals(expected, result);
    }
}