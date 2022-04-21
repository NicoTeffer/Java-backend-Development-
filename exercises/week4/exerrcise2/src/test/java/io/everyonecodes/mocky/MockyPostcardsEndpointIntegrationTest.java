package io.everyonecodes.mocky;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MockyPostcardsEndpointIntegrationTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    String url = "/mocky/postcards";

    Postcard expectedPostcard1 = new Postcard("Silvia", "Anne",
            "My trip is awesome so far! I'm looking forward to tell you all about it!");

    Postcard expectedPostcard2 = new Postcard("Tom", "Ryan",
            "You have to visit this place, mate! It's great!");

    @Test
    void getOnePostcard() {
        var response = testRestTemplate.getForObject(url + "/1", Postcard.class);
        Assertions.assertEquals(expectedPostcard1, response);
    }

    @Test
    void getTwoPostcards() {
        var response = testRestTemplate.getForObject(url + "/2", Postcard[].class);
        var result = List.of(response);

        var expected = List.of(expectedPostcard1, expectedPostcard2);
        Assertions.assertEquals(expected, result);
    }
}