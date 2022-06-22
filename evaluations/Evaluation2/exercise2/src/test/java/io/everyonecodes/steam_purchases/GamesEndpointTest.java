package io.everyonecodes.steam_purchases;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GamesEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    PurchaseService purchaseService;

    String url = "/games";

    @Test
    void getAllGames() {
        testRestTemplate.getForObject(url, Game[].class);

        Mockito.verify(purchaseService).getAllGames();
    }
}