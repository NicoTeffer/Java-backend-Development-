package io.everyonecodes.secret_agent_handshakes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HandshakeNumberToMoveTranslatorTest {

    @Autowired
    HandshakeNumberToMoveTranslator handshakeNumberToMoveTranslator;

    @Test
    void test(){
        var result = handshakeNumberToMoveTranslator.translate(3);
        var expected = "little finger grab";
        Assertions.assertEquals(expected,result);
    }
}