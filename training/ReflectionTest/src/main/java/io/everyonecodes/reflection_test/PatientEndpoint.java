package io.everyonecodes.reflection_test;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class PatientEndpoint {

    private final List<Patient> patients;

    public PatientEndpoint(List<Patient> patients) {
        this.patients = patients;
    }

    @PostMapping("/{name}")
    Patient post(@RequestBody String name){
        patients.add(new Patient(name));
        return new Patient(name);
    }
}
