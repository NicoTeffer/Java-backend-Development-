package io.everyonecodes.lorem_ipsum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class   LoremIpsumEndpointIntegrationTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @SpyBean
    RestTemplate restTemplate;

    String url = "/loremipsum";

    @Test
    void getLoremIpsumIntegrate() {
        String response = testRestTemplate.getForObject(url, String.class);

        Assertions.assertNotNull(response);
        Assertions.assertTrue(response.contains("Lorem ipsum dolor sit amet"));
        String apiUrl = "https://loripsum.net/api";
        Mockito.verify(restTemplate).getForObject(apiUrl, String.class);
    }
}