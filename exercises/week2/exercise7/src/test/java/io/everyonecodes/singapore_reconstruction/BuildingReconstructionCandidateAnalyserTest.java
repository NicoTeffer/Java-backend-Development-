package io.everyonecodes.singapore_reconstruction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BuildingReconstructionCandidateAnalyserTest {

    @Autowired
    BuildingReconstructionCandidateAnalyser buildingReconstructionCandidateAnalyser;

    @Test
    void findCandidates() {
        var result = buildingReconstructionCandidateAnalyser.findCandidates();
        LocalDate localDate = LocalDate.of(1934, 2, 20);
        var expected = List.of(
                new Building("Eliptic Appartments", LocalDate.of(1993, 5, 3), false),
                new Building("New World Amusement Park", LocalDate.of(1991, 8, 1), false)
        );
        Assertions.assertEquals(expected, result);
    }
}