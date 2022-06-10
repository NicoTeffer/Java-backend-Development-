package io.everyonecodes.marco;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class PoloClientTest {

    @Autowired
    PoloClient poloClient;

    @MockBean
    RestTemplate restTemplate; // Mocking the Rest Template

    String url = "http://localhost:9001/polo";

    @Test
    void post() {
        String message = "something";
        String expected = "Answer";
        // TODO: when {method}. thenReturn (expected).
        Mockito.when(restTemplate.postForObject(url, message, String.class)).thenReturn(expected);
        String response = poloClient.post(message);
        Assertions.assertEquals(expected, response);
        Mockito.verify(restTemplate).postForObject(url, message, String.class);
    }
}