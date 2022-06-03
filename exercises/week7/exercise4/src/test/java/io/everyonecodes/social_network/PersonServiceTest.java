package io.everyonecodes.social_network;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class PersonServiceTest {

    @Autowired
    PersonService personService;

    @MockBean
    PersonRepository personRepository;

    @MockBean
    DtoTranslator translator;

    @Test
    void findAll() {
        Person person1 = new Person("name1");
        Person person2 = new Person("name2");
        Mockito.when(personRepository.findAll()).thenReturn(List.of(person1, person2));
        personService.findAll();

        Mockito.verify(personRepository).findAll();
        Mockito.verify(translator).translateToDTO(person1);
        Mockito.verify(translator).translateToDTO(person2);
    }

    @Test
    void save() {
        PersonDTO personDTO = new PersonDTO("name");
        Person person = new Person("name");
        Mockito.when(translator.translateToPerson(personDTO)).thenReturn(person);

        personService.save(personDTO);

        Mockito.verify(translator).translateToPerson(personDTO);
        Mockito.verify(personRepository).save(person);
        Mockito.verify(translator).translateToDTO(person);
    }

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(Optional.empty(), Optional.empty()),
                Arguments.of(Optional.empty(), Optional.of(new Person("name"))),
                Arguments.of(Optional.of(new Person("name")), Optional.empty())
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void friendDoesNotFindBothPersons(Optional<Person> oPerson1, Optional<Person> oPerson2) {
        Long id1 = 123L;
        Long id2 = 111L;
        Mockito.when(personRepository.findById(id1)).thenReturn(oPerson1);
        Mockito.when(personRepository.findById(id2)).thenReturn(oPerson2);

        personService.friend(id1, id2);

        Mockito.verify(personRepository).findById(id1);
        Mockito.verify(personRepository).findById(id2);
        Mockito.verifyNoMoreInteractions(personRepository);

    }

    @ParameterizedTest
    @MethodSource("parameters")
    void unfriendDoesNotFindBothPersons(Optional<Person> oPerson1, Optional<Person> oPerson2) {
        Long id1 = 123L;
        Long id2 = 111L;
        Mockito.when(personRepository.findById(id1)).thenReturn(oPerson1);
        Mockito.when(personRepository.findById(id2)).thenReturn(oPerson2);

        personService.unfriend(id1, id2);

        Mockito.verify(personRepository).findById(id1);
        Mockito.verify(personRepository).findById(id2);
        Mockito.verifyNoMoreInteractions(personRepository);
    }

    @Test
    void friendFindsBothPersons() {
        Long id1 = 123L;
        Long id2 = 111L;
        Person person1 = new Person("name1");
        Person person2 = new Person("name2");

        Mockito.when(personRepository.findById(id1)).thenReturn(Optional.of(person1));
        Mockito.when(personRepository.findById(id2)).thenReturn(Optional.of(person2));

        personService.friend(id1, id2);

        Mockito.verify(personRepository).findById(id1);
        Mockito.verify(personRepository).findById(id2);
        Mockito.verify(personRepository).save(new Person("name1", List.of(person2)));
        Mockito.verify(personRepository).save(new Person("name2", List.of(person1)));
    }

    @Test
    void unfriendFindsBothPersons() {
        Long id1 = 123L;
        Long id2 = 111L;
        Person person1 = new Person(
                id1, "name1", new ArrayList<>(List.of(new Person(id2, "name2")))
        );
        Person person2 = new Person(
                id2, "name2", new ArrayList<>(List.of(new Person(id1, "name1")))
        );

        Mockito.when(personRepository.findById(id1)).thenReturn(Optional.of(person1));
        Mockito.when(personRepository.findById(id2)).thenReturn(Optional.of(person2));

        personService.unfriend(id1, id2);

        Mockito.verify(personRepository).findById(id1);
        Mockito.verify(personRepository).findById(id2);
        Mockito.verify(personRepository).save(new Person(id1, "name1", List.of()));
        Mockito.verify(personRepository).save(new Person(id2, "name2", List.of()));
    }
}