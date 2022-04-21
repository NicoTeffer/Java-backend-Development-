package io.everyonecodes.drhouse_admission;

public class Patient {

    private String uuid;
    private String name;
    private String symptom;

    public Patient() {
    }

    public Patient(String uuid, String name, String symptom) {
        this.uuid = uuid;
        this.name = name;
        this.symptom = symptom;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }
}
