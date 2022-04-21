package io.everyonecodes.drhouse_admission;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientEndpoint {

    private final Admission admission;

    public PatientEndpoint(Admission admission) {
        this.admission = admission;
    }

    @PostMapping
    Patient post(@RequestBody Patient patient) {
        return admission.admit(patient);
    }
}
