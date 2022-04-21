package io.everyonecodes.trickster;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class CupsClientTest {

    @Autowired
    CupsClient cupsClient;

    @MockBean
    RestTemplate restTemplate;

    @Value("${cup.urls}")
    List<String> urls;

    @Test
    void checkForCoin() {
        int cup = 1;
        var url = urls.get(cup);
        Mockito.when(restTemplate.getForObject(url, Boolean.class)).thenReturn(true);
        var result = cupsClient.checkForCoin(cup);
        Assertions.assertTrue(result);
        Mockito.verify(restTemplate).getForObject(url, Boolean.class);
    }

    @Test
    void placeCoin() {
        int cup = 1;
        var url = urls.get(cup);
        cupsClient.placeCoin(cup);
        Mockito.verify(restTemplate).put(url, null);
    }

    @Test
    void removeCoin() {
        int cup = 1;
        var url = urls.get(cup);
        cupsClient.removeCoin(cup);
        Mockito.verify(restTemplate).delete(url);
    }

    @Test
    void numberOfCups() {
        int expected = urls.size();
        int result = cupsClient.numberOfCups();
        Assertions.assertEquals(expected, result);
    }
}