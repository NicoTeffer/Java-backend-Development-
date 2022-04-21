package io.everyonecodes.cup;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CupTest {

    Cup cup = new Cup();

    @Test
    void hasCoin() {
        var result = cup.hasCoin();
        Assertions.assertFalse(result);
    }

    @Test
    void placeCoin() {
        cup.placeCoin();
        var result = cup.hasCoin();
        Assertions.assertTrue(result);
    }

    @Test
    void removeCoin() {
        cup.removeCoin();
        var result = cup.hasCoin();
        Assertions.assertFalse(result);
    }
}