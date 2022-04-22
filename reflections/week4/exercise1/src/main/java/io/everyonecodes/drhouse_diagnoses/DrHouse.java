package io.everyonecodes.drhouse_diagnoses;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrHouse {

    private final List<Diagnosis> diagnoses;

    public DrHouse(List<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public String diagnose(Patient patient) {
        var symptom = patient.getSymptoms();
        var diagnosis = "";
        for (Diagnosis diagnose : diagnoses) {
            if (diagnose.getSymptoms().equals(symptom)) {
                return diagnose.getName();
            } else {
                diagnosis = "lupus";
            }
        }
        return diagnosis;
    }
}
