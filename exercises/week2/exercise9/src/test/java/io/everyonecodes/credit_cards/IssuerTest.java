package io.everyonecodes.credit_cards;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Set;

class IssuerTest {

    Issuer issuer = new Issuer("American Express", Set.of("34", "37"), Collections.singleton(15));

    @Test
    void issues() {
        var result = issuer.issues("378282246310005");
        Assertions.assertTrue(result);
    }
}