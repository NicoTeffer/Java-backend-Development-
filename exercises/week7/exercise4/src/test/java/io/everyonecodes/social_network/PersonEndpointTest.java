package io.everyonecodes.social_network;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PersonEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    PersonService personService;

    String url = "/persons";

    @Test
    void get() {
        testRestTemplate.getForObject(url, PersonDTO[].class);

        Mockito.verify(personService).findAll();
    }

    @Test
    void post() {
        PersonDTO personDTO = new PersonDTO("name");
        testRestTemplate.postForObject(url, personDTO, PersonDTO.class);

        Mockito.verify(personService).save(personDTO);
    }

    @Test
    void friend() {
        Long id1 = 123L;
        Long id2 = 111L;
        String friendUrl = url + "/" + id1 + "/friend/" + id2;
        testRestTemplate.put(friendUrl, null);

        Mockito.verify(personService).friend(id1, id2);
    }

    @Test
    void unfriend() {
        Long id1 = 123L;
        Long id2 = 111L;
        String unfriendUrl = url + "/" + id1 + "/unfriend/" + id2;
        testRestTemplate.put(unfriendUrl, null);

        Mockito.verify(personService).unfriend(id1, id2);
    }
}