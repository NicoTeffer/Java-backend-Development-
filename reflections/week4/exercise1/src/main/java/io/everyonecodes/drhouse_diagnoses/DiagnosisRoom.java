package io.everyonecodes.drhouse_diagnoses;

import org.springframework.stereotype.Service;

@Service
public class DiagnosisRoom {

    private final DrHouse drHouse;

    public DiagnosisRoom(DrHouse drHouse) {
        this.drHouse = drHouse;
    }

    public Patient diagnose(Patient patient) {
        var symptom = patient.getSymptoms();
        var diagnoseDoc = drHouse.diagnose(patient);
        patient.setDiagnosis(diagnoseDoc);
        System.out.println("Patient with the symptoms: " + symptom + "; " + "diagnosed with: " + diagnoseDoc);
        return patient;
    }
}
