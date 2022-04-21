package io.everyonecodes.dorothy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class DorothyTest {

    @Autowired
    Dorothy dorothy;

    @MockBean
    RestTemplate restTemplate;

    String urlWizard = "http://localhost:9001/wizard";

    @Test
    void homeIs() {
        String wizard = "http://localhost:9002/home";
        String responseWizard = "Kansas";
        Mockito.when(restTemplate.getForObject(urlWizard, String.class)).thenReturn(wizard);
        Mockito.when(restTemplate.getForObject(wizard,String.class)).thenReturn(responseWizard);
        var response = dorothy.homeIs();
        var expected = "My home is Kansas.";
        Assertions.assertEquals(expected, response);
        Mockito.verify(restTemplate).getForObject(urlWizard, String.class);
    }
}