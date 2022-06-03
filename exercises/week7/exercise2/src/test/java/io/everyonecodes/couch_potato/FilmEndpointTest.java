package io.everyonecodes.couch_potato;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FilmEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    FilmRepository filmRepository;

    String url = "/films";

    @Test
    void getFilms() {
        testRestTemplate.getForObject(url, Film[].class);

        Mockito.verify(filmRepository).findAll();
    }

    @Test
    void postFilm() {
        Film test = new Film("Arrival", 5);
        testRestTemplate.postForObject(url, test, Film.class);

        Mockito.verify(filmRepository).save(test);
    }
}