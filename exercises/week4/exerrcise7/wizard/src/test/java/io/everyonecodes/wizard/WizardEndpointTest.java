package io.everyonecodes.wizard;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WizardEndpointTest {

    @Autowired
    WizardEndpoint wizardEndpoint;

    @Test
    void getHomeUrl() {
        var response = wizardEndpoint.getHomeUrl();
        var expected = "http://localhost:9002/home";
        Assertions.assertEquals(expected, response);
    }
}