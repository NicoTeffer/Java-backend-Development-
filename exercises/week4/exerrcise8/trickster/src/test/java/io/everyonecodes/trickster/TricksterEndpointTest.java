package io.everyonecodes.trickster;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TricksterEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    Trickster trickster;

    String urlPlay = "/play";
    String urlChoose = "/choose/";

    @Test
    void playGame() {
        testRestTemplate.getForObject(urlPlay,String.class);
        Mockito.verify(trickster).playGame();
    }

    @Test
    void checkCup() {
        int cup = 2;
        testRestTemplate.getForObject(urlChoose + cup,String.class);
        Mockito.verify(trickster).coinCheck(cup);
    }
}