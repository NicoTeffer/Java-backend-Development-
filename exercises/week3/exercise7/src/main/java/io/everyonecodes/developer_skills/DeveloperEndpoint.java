package io.everyonecodes.developer_skills;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/developers")
public class DeveloperEndpoint {

    private final DeveloperService developerService;

    public DeveloperEndpoint(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @GetMapping
    public List<Developer> getAllDevs() {
        return developerService.findAll();
    }

    //TODO: Has the “/developers/skills/{skills}” get mapping that returns the list of all available developers
    // who have the required skills.
    @GetMapping("/skills/{skills}")  // < --- NOTE: "/developers" already mapped! It should be the "/skills/{skills}" mapping
    public List<Developer> getDevsWithSkills(@PathVariable String skills) {
        return developerService.findBy(skills);
    }
}
