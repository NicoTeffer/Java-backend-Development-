package io.everyonecodes.emergency_numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmergencyNumberProviderTest {

    @Autowired
    EmergencyNumberProvider emergencyNumberProvider;

    @ParameterizedTest
    @CsvSource({
            "'FiRe BriGade', 122",
            "'POLiCe', 133",
            "'help11einseinself!', 112",
            "' ', 112",
    })
    void test(String input, int expected) {
        var result = emergencyNumberProvider.provide(input);
        Assertions.assertEquals(expected, result);
    }
}