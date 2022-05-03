package io.everyonecodes.drhouse_diagnoses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class DiagnosisRoomTest {

    @Autowired
    DiagnosisRoom diagnosisRoom;

    @MockBean
    DrHouse drHouse;

    @Test
    void diagnose_returnsDiagnosis() {
        Patient test0r = new Patient("3bc716e1-9c68-4c42-bc89-62b4e9c67f69", "Test0r", "fatigue, appear pale", "");
        String diagnosis = "anemia";
        var test0rBeforeDiagnosis = test0r.getDiagnosis();
        Assertions.assertEquals("", test0rBeforeDiagnosis);
        Mockito.when(drHouse.diagnose(test0r)).thenReturn(diagnosis);
        var result = diagnosisRoom.diagnose(test0r);
        Patient test0rDiagnosed = new Patient("3bc716e1-9c68-4c42-bc89-62b4e9c67f69", "Test0r", "fatigue, appear pale", diagnosis);
        Assertions.assertEquals(test0rDiagnosed, result);
        Mockito.verify(drHouse).diagnose(test0r);
    }

    @Test
    void diagnose_returnsLupus() {
        Patient test0r = new Patient("3bc716e1-9c68-4c42-bc89-62b4e9c67f69", "Test0r", "dizziness", "");
        String diagnosis = "lupus";
        var test0rBeforeDiagnosis = test0r.getDiagnosis();
        Assertions.assertEquals("", test0rBeforeDiagnosis);
        Mockito.when(drHouse.diagnose(test0r)).thenReturn(diagnosis);
        var result = diagnosisRoom.diagnose(test0r);
        Patient test0rDiagnosed = new Patient("3bc716e1-9c68-4c42-bc89-62b4e9c67f69", "Test0r", "dizziness", diagnosis);
        Assertions.assertEquals(test0rDiagnosed, result);
        Mockito.verify(drHouse).diagnose(test0r);
    }
}