package io.everyonecodes.developer_skills;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ConfigurationProperties("skills")
public class DeveloperService {

    private final List<Developer> developers;

    public DeveloperService(List<Developer> developers) {
        this.developers = developers;
    }

    public List<Developer> getDevelopers() {
        return developers;
    }

    public List<Developer> findAll() {
        return developers;
    }

    //TODO: Has the findBy method that receives a String with the requested skills separated by spaces
    // and returns a list of all the available developers that have at least the provided skills.
    public List<Developer> findBy(String skills) {
        var split = List.of(skills.split(" "));
        return developers.stream()
                .filter(developer -> developer.getSkills().containsAll(split)).toList();
    }
}
