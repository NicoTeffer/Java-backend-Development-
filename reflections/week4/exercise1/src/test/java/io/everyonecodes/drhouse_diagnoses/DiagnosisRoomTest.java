package io.everyonecodes.drhouse_diagnoses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DiagnosisRoomTest {

    @Autowired
    DiagnosisRoom diagnosisRoom;

    @Test
    void diagnose() {
        Patient test0r = new Patient("3bc716e1-9c68-4c42-bc89-62b4e9c67f69","Test0r","fatigue, appear pale","");
        var result = diagnosisRoom.diagnose(test0r);
        var expected = "anemia";
        Assertions.assertEquals(expected, result);
    }
}