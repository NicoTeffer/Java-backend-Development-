package io.everyonecodes.drhouse_admission;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Admission {

    private UUIDProvider uuidProvider;

    public Patient admit(Patient patient){
        patient.setUuid(UUID.randomUUID().toString());
        return patient;
    }
}
