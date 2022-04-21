package io.everyonecodes.marathon_integration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class MarathonClientTest {

    @Autowired
    MarathonClient marathonClient;

    @MockBean
    RestTemplate restTemplate;

    String url = "http://localhost:8500";

    @Test
    void getWinner() {
        Runner testRunner = new Runner("TestRunner", Duration.parse("PT1H1M34S"));
        Mockito.when(restTemplate.getForObject(url + "/runners/winner", Runner.class)).thenReturn(testRunner);
        var response = marathonClient.getWinner();
        Assertions.assertEquals(testRunner, response);
        Mockito.verify(restTemplate).getForObject(url + "/runners/winner", Runner.class);
    }

    @Test
    void post() {
        Runner testRunner = new Runner("TestRunner", Duration.parse("PT1H1M34S"));
        Mockito.when(restTemplate.postForObject(url + "/runners", testRunner, Runner.class)).thenReturn(testRunner);
        var response = marathonClient.post(testRunner);
        Assertions.assertEquals(testRunner, response);
        Mockito.verify(restTemplate).postForObject(url + "/runners", testRunner, Runner.class);
    }
}