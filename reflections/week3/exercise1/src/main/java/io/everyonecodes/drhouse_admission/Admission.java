package io.everyonecodes.drhouse_admission;

import org.springframework.stereotype.Service;

@Service
public class Admission {
    private final UUIDProvider uuidProvider;

    public Admission(UUIDProvider uuidProvider) {
        this.uuidProvider = uuidProvider;
    }

    public Patient admit(Patient patient) {
        uuidProvider.provideUUID(patient);
        return patient;
    }
}
