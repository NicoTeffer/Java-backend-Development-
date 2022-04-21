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
class MockyTextsEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    RestTemplate restTemplate;

    @Value("${mocky.texts.1}")
    String oneTextUrl;

    @Value("${mocky.texts.2}")
    String twoTextsUrl;

    String url = "/mocky/texts";

    @Test
    void getOne() {
        String expected = "test";
        Mockito.when(restTemplate.getForObject(oneTextUrl, String.class)).thenReturn(expected);

        String response = testRestTemplate.getForObject(url + "/1", String.class);

        Assertions.assertEquals(expected, response);
        Mockito.verify(restTemplate).getForObject(oneTextUrl, String.class);
    }

    @Test
    void getTwo() {
        List<String> expected = List.of("test1", "test2");
        Mockito.when(restTemplate.getForObject(twoTextsUrl, String[].class)).thenReturn(expected.toArray(String[]::new));

        String[] response = testRestTemplate.getForObject(url + "/2", String[].class);
        List<String> result = List.of(response);

        Assertions.assertEquals(expected, result);
        Mockito.verify(restTemplate).getForObject(twoTextsUrl, String[].class);
    }
}