package io.everyonecodes.credit_cards;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class LuhnTest {

    @Autowired
    Luhn luhn;

    @Test
    void isValid() {
        var result = luhn.isValid("378282246310005");
        Assertions.assertTrue(result);
    }
}