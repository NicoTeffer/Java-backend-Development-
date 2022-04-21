package io.everyonecodes.mocky;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MockyPostcardsEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    RestTemplate restTemplate;

    @Value("${mocky.postcards.1}")
    String onePostcardUrl;

    @Value("${mocky.postcards.2}")
    List<String> twoPostcardsUrl;

    String url = "/mocky/postcards";

    Postcard expectedPostcard1 = new Postcard("Silvia", "Anne",
            "My trip is awesome so far! I'm looking forward to tell you all about it!");

    Postcard expectedPostcard2 = new Postcard("Tom", "Ryan",
            "You have to visit this place, mate! It's great!");

    @Test
    void getOnePostcard() {
        Mockito.when(restTemplate.getForObject(onePostcardUrl, Postcard.class)).thenReturn(expectedPostcard1);

        var result = testRestTemplate.getForObject(url + "/1", Postcard.class);

        Assertions.assertEquals(expectedPostcard1, result);
        Mockito.verify(restTemplate).getForObject(onePostcardUrl, Postcard.class);
    }

    @Test
    void getTwoPostcards() {
        Mockito.when(restTemplate.getForObject(twoPostcardsUrl.get(0), Postcard.class)).thenReturn(expectedPostcard1);
        Mockito.when(restTemplate.getForObject(twoPostcardsUrl.get(1), Postcard.class)).thenReturn(expectedPostcard2);

        var response = testRestTemplate.getForObject(url + "/2", Postcard[].class);
        var result = List.of(response);

        var expected = List.of(expectedPostcard1, expectedPostcard2);

        Assertions.assertEquals(expected, result);
        Mockito.verify(restTemplate).getForObject(twoPostcardsUrl.get(0), Postcard.class);
        Mockito.verify(restTemplate).getForObject(twoPostcardsUrl.get(1), Postcard.class);
    }
}