package io.everyonecodes.marathon_integration;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MarathonIntegrationEndpointTest {

    @Autowired
    MarathonIntegrationEndpoint marathonIntegrationEndpoint;

    @MockBean
    MarathonTester marathonTester;

    String url = "/marathon/integration";

    @Test
    void getIntegration() {
        marathonTester.getIntegrationTest();
        Mockito.verify(marathonTester).getIntegrationTest();
    }
}