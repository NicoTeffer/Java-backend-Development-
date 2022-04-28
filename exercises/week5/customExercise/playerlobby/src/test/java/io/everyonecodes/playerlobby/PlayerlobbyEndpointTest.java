package io.everyonecodes.playerlobby;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PlayerlobbyEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Value("${match.url}")
    String match;

    String url = "/playerlobby";

    @Test
    void getMatch() {
        String response = testRestTemplate.getForObject(url, String.class);
        Assertions.assertEquals(match, response);
    }
}