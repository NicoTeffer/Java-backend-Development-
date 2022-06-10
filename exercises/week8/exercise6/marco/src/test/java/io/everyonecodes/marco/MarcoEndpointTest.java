package io.everyonecodes.marco;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MarcoEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    PoloClient poloClient;

    String url = "/marco/";

    @Test
    void getMessage() {
        String post = "something";
        String expected = "What?";
        Mockito.when(poloClient.post(post)).thenReturn(expected);
        String response = testRestTemplate.getForObject(url + post,String.class);
        Mockito.verify(poloClient).post(post);
    }
}