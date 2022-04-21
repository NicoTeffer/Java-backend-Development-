package io.everyonecodes.reflection_test;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PatientService {

    private List<Patient> patients;

    public PatientService(List<Patient> patients) {
        this.patients = patients;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public void add(Patient patient){
        patients.add(patient);
    }

    public Patient getSpecificPatientName(String name){
        return patients.stream()
                .filter(patient -> patient.getName().equalsIgnoreCase(name))
                .findFirst().get();
    }

    public Patient getSpecificPatientUUID(UUID uuid){
        return patients.stream()
                .filter(patient -> patient.getUuid().equals(uuid))
                .findFirst().get();
    }
}
