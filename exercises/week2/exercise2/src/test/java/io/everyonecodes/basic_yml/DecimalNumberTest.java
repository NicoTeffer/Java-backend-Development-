package io.everyonecodes.basic_yml;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DecimalNumberTest {

    @Autowired
    DecimalNumber decimalNumber;

    @Test
    void getDecimalNumber() {
        var result = decimalNumber.getDecimalNumber();
        var expected = 5.5;
        Assertions.assertEquals(expected, result);
    }
}