package io.everyonecodes.mocky;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MockyTextsEndpointIntegrationTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    String url = "/mocky/texts";

    @Test
    void getOne() {
        String response = testRestTemplate.getForObject(url + "/1", String.class);

        String expected = "Yay, it worked! This message comes from an external API in the cloud :)";
        Assertions.assertEquals(expected, response);
    }

    @Test
    void getTwo() {
        var response = testRestTemplate.getForObject(url + "/2", String[].class);
        var result = List.of(response);

        var expected = List.of(
                "You are doing an amazing job!",
                "Keep on going, you're learning fast"
        );
        Assertions.assertEquals(expected, result);
    }
}