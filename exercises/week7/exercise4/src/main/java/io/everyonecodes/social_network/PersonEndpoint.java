package io.everyonecodes.social_network;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonEndpoint {
    private final PersonService personService;

    public PersonEndpoint(PersonService personService) {
        this.personService = personService;
    }

    //TODO: GET to “/persons” -> returns all saved Persons as a list of PersonDTO.
    @GetMapping
    List<PersonDTO> get() {
        return personService.findAll();
    }

    //TODO: POST a PersonDTO with only its name to “/persons” ->
    // transforms the PersonDTO into a Person, saves the Person, transforms it back to a PersonDTO
    // and returns the new PersonDTO.
    @PostMapping
    PersonDTO post(@RequestBody PersonDTO personDTO) {
        return personService.save(personDTO);
    }

    //TODO: PUT to “/persons/{id1}/friend/{id2}” -> connects the two Persons with id1 and id2 as friends.
    @PutMapping("/{id1}/friend/{id2}")
    void friend(@PathVariable Long id1, @PathVariable Long id2) {
        personService.friend(id1, id2);
    }

    //TODO: PUT to “/persons/{id1}/unfriend/{id2}” ->
    // disconnects the friendship between the two Persons with id1 and id2.
    @PutMapping("/{id1}/unfriend/{id2}")
    void unfriend(@PathVariable Long id1, @PathVariable Long id2) {
        personService.unfriend(id1, id2);
    }
}
