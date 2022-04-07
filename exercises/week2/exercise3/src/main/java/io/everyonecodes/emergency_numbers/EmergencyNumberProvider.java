package io.everyonecodes.emergency_numbers;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class EmergencyNumberProvider {
    // TODO: List - example :
    // TODO: private final List<EmergencyNumber> emergencyNumbers;
    private final Set<EmergencyNumber> emergencyNumbers;
    private final GeneralEmergency generalEmergency;

    public EmergencyNumberProvider(
            PoliceEmergency policeEmergency,
            FireEmergency fireEmergency,
            GeneralEmergency generalEmergency
    ) {
        emergencyNumbers = Set.of(policeEmergency, fireEmergency);
        //TODO: emergencyNumbers = List.of(policeEmergency, fireEmergency);
        this.generalEmergency = generalEmergency;
    }

    public int provide(String name) {
        return emergencyNumbers.stream()
                .filter(emergencyNumber -> emergencyNumber.getName().equalsIgnoreCase(name))
                .map(EmergencyNumber::getNumber)
                .findFirst()
                .orElse(generalEmergency.getNumber());
    }
}
