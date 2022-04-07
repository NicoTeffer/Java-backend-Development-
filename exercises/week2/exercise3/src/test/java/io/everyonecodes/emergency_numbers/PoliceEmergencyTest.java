package io.everyonecodes.emergency_numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PoliceEmergencyTest {

    @Autowired
    PoliceEmergency policeEmergency;

    @Test
    void getName() {
        var result = policeEmergency.getName();
        var expected = "Police";
        Assertions.assertEquals(expected, result);
    }

    @Test
    void getNumber() {
        var result = policeEmergency.getNumber();
        var expected = 133;
        Assertions.assertEquals(expected, result);
    }
}