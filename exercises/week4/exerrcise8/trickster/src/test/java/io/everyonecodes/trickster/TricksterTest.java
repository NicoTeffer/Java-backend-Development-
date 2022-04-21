package io.everyonecodes.trickster;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Random;

import static org.mockito.ArgumentMatchers.anyInt;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class TricksterTest {

    @Autowired
    Trickster trickster;

    @MockBean
    CupsClient cupsClient;

    @MockBean
    Random random;

    @Value("${cup.urls}")
    List<String> urls;

    @Test
    void playGame() {
        int numberOfCups = urls.size();
        int cup = 2;
        Mockito.when(cupsClient.numberOfCups()).thenReturn(numberOfCups);
        Mockito.when(random.nextInt(anyInt())).thenReturn(cup);
        String expected = "The cups have been shuffled!";
        String result = trickster.playGame();
        Assertions.assertEquals(expected, result);
        Mockito.verify(cupsClient, Mockito.times(numberOfCups)).removeCoin(anyInt());
        Mockito.verify(cupsClient).placeCoin(cup);
    }

    @Test
    void coinCheck() {
        int cup = 2;
        boolean expected = true;
        Mockito.when(cupsClient.checkForCoin(anyInt())).thenReturn(expected);
        boolean result = cupsClient.checkForCoin(cup);
        Assertions.assertEquals(expected, result);
    }
}