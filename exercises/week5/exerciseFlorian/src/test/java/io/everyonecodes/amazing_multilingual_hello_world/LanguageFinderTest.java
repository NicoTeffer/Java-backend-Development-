package io.everyonecodes.amazing_multilingual_hello_world;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class LanguageFinderTest {

    @Autowired
    LanguageFinder languageFinder;

    @Test
    void checkLanguage() {
        var result = languageFinder.checkLanguage("italian");
        var expected = "ciao mondo";
        Assertions.assertEquals(expected, result);
    }
}