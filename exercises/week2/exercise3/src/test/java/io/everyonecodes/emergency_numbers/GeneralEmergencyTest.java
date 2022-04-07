package io.everyonecodes.emergency_numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GeneralEmergencyTest {

    @Autowired
    GeneralEmergency generalEmergency;

    @Test
    void getName() {
        var result = generalEmergency.getName();
        var expected = "General emergency";
        Assertions.assertEquals(expected, result);
    }

    @Test
    void getNumber() {
        var result = generalEmergency.getNumber();
        var expected = 112;
        Assertions.assertEquals(expected, result);
    }
}