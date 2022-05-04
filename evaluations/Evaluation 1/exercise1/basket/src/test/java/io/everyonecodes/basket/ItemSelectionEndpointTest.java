package io.everyonecodes.basket;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ItemSelectionEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    Basket basket;

    String url = "/itemselections";

    @Test
    void post() {
        ItemSelection testSelection =
                new ItemSelection("samuel@email.com", "item1", 1.0);
        testRestTemplate.postForObject(url,testSelection,ItemSelection.class);
        Mockito.verify(basket).transformItemSelection(testSelection);
    }
}