package io.everyonecodes.social_network;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final DtoTranslator translator;

    public PersonService(PersonRepository personRepository, DtoTranslator translator) {
        this.personRepository = personRepository;
        this.translator = translator;
    }

    public List<PersonDTO> findAll() {

        return personRepository.findAll().stream()
                .map(translator::translateToDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO save(PersonDTO personDTO) {
        Person person = translator.translateToPerson(personDTO);
        personRepository.save(person);
        return translator.translateToDTO(person);
    }

    public void friend(Long id1, Long id2) {
        Optional<Person> oPerson1 = personRepository.findById(id1);
        Optional<Person> oPerson2 = personRepository.findById(id2);
        if (oPerson1.isEmpty() || oPerson2.isEmpty()) {
            return;
        }
        Person person1 = oPerson1.get();
        Person person2 = oPerson2.get();
        person1.getFriends().add(person2);
        person2.getFriends().add(person1);
        personRepository.save(person1);
        personRepository.save(person2);
    }

    public void unfriend(Long id1, Long id2) {
        Optional<Person> oPerson1 = personRepository.findById(id1);
        Optional<Person> oPerson2 = personRepository.findById(id2);
        if (oPerson1.isEmpty() || oPerson2.isEmpty()) {
            return;
        }
        Person person1 = oPerson1.get();
        Person person2 = oPerson2.get();
        person1.getFriends().remove(person2);
        person2.getFriends().remove(person1);
        personRepository.save(person1);
        personRepository.save(person2);
    }
}
