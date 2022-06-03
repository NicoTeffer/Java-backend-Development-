package io.everyonecodes.social_network;

import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class DtoTranslator {

    public PersonDTO translateToDTO (Person person){
        return new PersonDTO(
                person.getId(),
                person.getName(),
                person.getFriends().stream()
                        .map(Person::getName)
                        .collect(Collectors.toList())
        );
    }

    public Person translateToPerson(PersonDTO personDTO){
        return new Person (personDTO.getName());
    }
}
