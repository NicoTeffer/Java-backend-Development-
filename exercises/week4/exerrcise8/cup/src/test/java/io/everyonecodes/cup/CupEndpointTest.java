package io.everyonecodes.cup;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CupEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    Cup cup;

    String url = "/cup";

    @Test
    void get() {
        Mockito.when(cup.hasCoin()).thenReturn(false);
        var result = testRestTemplate.getForObject(url, Boolean.class);
        var expected = false;
        Assertions.assertEquals(expected, result);
        Mockito.verify(cup).hasCoin();
    }

    @Test
    void put() {
        testRestTemplate.put(url,Boolean.class);
        cup.placeCoin();
        Mockito.verify(cup,Mockito.times(2)).placeCoin();
    }

    @Test
    void delete() {
        testRestTemplate.delete(url);
        cup.removeCoin();
        Mockito.verify(cup, Mockito.times(2)).removeCoin();
    }
}