package io.everyonecodes.announcer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class AnnouncerTest {

    @Autowired
    Announcer announcer;

    @MockBean
    RestTemplate restTemplate;

    @Value("${playerlobby.url}")
    String playerlobbyUrl;

    @Test
    void findMatch() {
        String matchUrl = "matchUrl";
        Mockito.when(restTemplate.getForObject(playerlobbyUrl, String.class)).thenReturn(matchUrl);
        String match = "Match";
        Mockito.when(restTemplate.getForObject(matchUrl, String.class)).thenReturn(match);
        String result = announcer.findMatch();
        String expected = "The next match is: " + match;
        Assertions.assertEquals(expected, result);
        Mockito.verify(restTemplate).getForObject(playerlobbyUrl, String.class);
        Mockito.verify(restTemplate).getForObject(matchUrl, String.class);
    }
}