package io.everyonecodes.amazing_multilingual_hello_world;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AmazingMultilingualHelloWorldEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    AmazingMultilingualHelloWorldEndpoint endpoint;

    String url = "/helloworld/";

    @Test
    void getHelloWorldInLanguage() {
        Mockito.when(endpoint.getHelloWorldInLanguage("hungarian")).thenReturn("helló világ");
        var response = testRestTemplate.getForObject(url + "hungarian", String.class);
        var expected = "helló világ";
        Assertions.assertEquals(expected, response);
        Mockito.verify(endpoint).getHelloWorldInLanguage("hungarian");
    }
}