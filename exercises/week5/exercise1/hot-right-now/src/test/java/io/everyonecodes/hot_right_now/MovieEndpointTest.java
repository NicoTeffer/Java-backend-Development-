package io.everyonecodes.hot_right_now;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MovieEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    MovieStore movieStore;

    String url = "/movies";

    @Test
    void getHotRightNow() {
        Movie movie1 = new Movie("a", "plota");
        Movie movie2 = new Movie("b", "plotb");
        Movie movie3 = new Movie("c", "plotc");
        var expected = List.of(movie1, movie2, movie3);
        Mockito.when(movieStore.getHotrightnow()).thenReturn(expected);
        var response = testRestTemplate.getForObject(url, Movie[].class);
        var result = List.of(response);
        Assertions.assertEquals(expected, result);
        Mockito.verify(movieStore).getHotrightnow();
    }
}