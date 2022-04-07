package io.everyonecodes.advanced_yml;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties("advanced")
public class NaturalNumber {
    private int naturalNumber;

    public NaturalNumber() {
    }

    public int getNaturalNumber() {
        return naturalNumber;
    }

    public void setNaturalNumber(int naturalNumber) {
        this.naturalNumber = naturalNumber;
    }
}