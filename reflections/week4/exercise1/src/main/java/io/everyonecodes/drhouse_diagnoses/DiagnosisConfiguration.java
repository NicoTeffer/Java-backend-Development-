package io.everyonecodes.drhouse_diagnoses;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties("drhouse2")
public class DiagnosisConfiguration {
    private List<Diagnosis> diagnoses;

    @Bean
    List<Diagnosis> diagnosis() {
        return diagnoses;
    }

    void setDiagnoses(List<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }
}
