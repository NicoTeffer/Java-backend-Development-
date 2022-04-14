package io.everyonecodes.advanced_types;

import java.util.Set;

public class Student {

    private String name;
    private Set<String> languages;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<String> languages) {
        this.languages = languages;
    }
}
