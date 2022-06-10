package io.everyonecodes.polo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PoloTest {

    Polo polo = new Polo();

    @Test
    void test_polo() {
        var result = polo.poloOrWhat("Marco");
        var expected = "Polo";
        Assertions.assertEquals(expected,result);
    }

    @Test
    void test_what() {
        var result = polo.poloOrWhat("honig");
        var expected = "What?";
        Assertions.assertEquals(expected,result);
    }
}