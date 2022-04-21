package io.everyonecodes.polo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PoloEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    Polo polo;

    String url = "/polo";

    @Test
    void post() {
        String post = "something";
        String expected = "What?";
        testRestTemplate.postForObject(url, post, String.class);
        Mockito.verify(polo).poloOrWhat(post);
    }
}