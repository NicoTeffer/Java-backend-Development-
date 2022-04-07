package io.everyonecodes.basic_yml;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class NaturalNumberTest {

    @Autowired
    NaturalNumber naturalNumber;

    @Test
    void getNaturalNumber() {
        var result = naturalNumber.getNaturalNumber();
        var expected = 5;
        Assertions.assertEquals(expected, result);
    }
}