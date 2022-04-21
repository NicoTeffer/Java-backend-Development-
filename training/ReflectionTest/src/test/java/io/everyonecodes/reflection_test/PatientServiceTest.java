package io.everyonecodes.reflection_test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PatientServiceTest {

    @Autowired
    PatientService patientService;

    @Test
    void getPatients() {
        patientService.add(new Patient("John"));
        patientService.add(new Patient("James"));
        patientService.add(new Patient("Jim"));
        var result = patientService.getPatients();
        var expected = List.of(
                new Patient("John"),
                new Patient("James"),
                new Patient("Jim")
        );
        Assertions.assertEquals(expected, result);
    }

    @Test
    void getSpecificPatient() {
        Patient John = new Patient("John");
        Patient James = new Patient("James");
        Patient Jim = new Patient("Jim");
        patientService.add(John);
        patientService.add(Jim);
        patientService.add(James);
        var resultString = patientService.getSpecificPatientName("John");
        //var resultUUID = patientService.getSpecificPatientUUID(UUID.fromString("0da9fb95-908f-4128-86ca-4c1fa7f7bd32"));
        System.out.println(resultString.getUuid());
        Assertions.assertEquals(John, resultString);
        //Assertions.assertEquals(John,resultUUID);
    }
}