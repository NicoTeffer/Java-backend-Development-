package io.everyonecodes.drhouse_diagnoses;

import org.springframework.stereotype.Service;

@Service
public class DiagnosisRoom {

    private final DrHouse drHouse;

    public DiagnosisRoom(DrHouse drHouse) {
        this.drHouse = drHouse;
    }

    public String diagnose(Patient patient) {
        var symptom = patient.getSymptoms();
        var diagnoseDoc = drHouse.diagnose(patient);
        System.out.println("Patient with the symptoms: " + symptom + "; " + "diagnosed with: " + diagnoseDoc);
        return diagnoseDoc;
    }
}
