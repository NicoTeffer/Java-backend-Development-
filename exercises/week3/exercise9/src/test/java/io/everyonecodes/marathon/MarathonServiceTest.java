package io.everyonecodes.marathon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

class MarathonServiceTest {

    private MarathonService marathonService;

    @BeforeEach
    void setup() {
        marathonService = new MarathonService(new HashSet<>());
    }

    @Test
    void add() {
        Assertions.assertTrue(marathonService.getRunners().isEmpty());
        marathonService.add(new Runner("TestJohn", Duration.parse("PT1H1M34S")));
        var result = marathonService.getRunners();
        var expected = Set.of(new Runner("TestJohn", Duration.parse("PT1H1M34S")));
        Assertions.assertEquals(expected, result);
    }

    @Test
    void findWinner_WinnerResult() {
        marathonService.add(new Runner("James", Duration.parse("PT1H1M34S")));
        marathonService.add(new Runner("John", Duration.parse("PT1H1M31S")));
        marathonService.add(new Runner("Jim", Duration.parse("PT1H1M14S")));
        var oResult = marathonService.findWinner();
        var oExpected = Optional.of(new Runner("Jim", Duration.parse("PT1H1M14S")));
        Assertions.assertEquals(oExpected, oResult);
    }
}