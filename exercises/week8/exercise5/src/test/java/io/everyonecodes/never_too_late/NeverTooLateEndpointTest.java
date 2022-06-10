package io.everyonecodes.never_too_late;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class NeverTooLateEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    NeverTooLateService neverTooLateService;

    String url = "/";

    @Test
    void getMessage() {
        testRestTemplate.getForObject(url, String.class);

        Mockito.verify(neverTooLateService).getMessage();
    }
}