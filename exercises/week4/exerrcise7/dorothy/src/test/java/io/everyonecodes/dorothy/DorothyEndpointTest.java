package io.everyonecodes.dorothy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DorothyEndpointTest {

    @Autowired
    DorothyEndpoint dorothyEndpoint;

    @MockBean
    Dorothy dorothy;

    String url = "/dorothy";

    @Test
    void getDorothyHome() {
        String homeIs = "My Home is Kansas.";
        Mockito.when(dorothy.homeIs()).thenReturn(homeIs);
        var response = dorothyEndpoint.getDorothyHome();
        Assertions.assertEquals(homeIs, response);
        Mockito.verify(dorothy).homeIs();
    }
}