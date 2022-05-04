package io.everyonecodes.basket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SummaryEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    Basket basket;

    String url = "/summaries";

    @Test
    void get() {
        Summary testSummaryA = new Summary("a", "a", 1.00, 2.50, 3.50);
        Summary testSummaryB = new Summary("b", "b", 2.00, 2.50, 4.50);
        List<Summary> testSummaryList = List.of(testSummaryA, testSummaryB);
        Mockito.when(basket.getSummaries()).thenReturn(testSummaryList);
        var response = testRestTemplate.getForObject(url, Summary[].class);
        var result = List.of(response);
        Assertions.assertEquals(testSummaryList, result);
        Mockito.verify(basket).getSummaries();
    }
}