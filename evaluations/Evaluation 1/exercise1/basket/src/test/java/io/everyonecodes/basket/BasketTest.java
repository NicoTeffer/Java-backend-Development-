package io.everyonecodes.basket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class BasketTest {

    @Autowired
    Basket basket;

    @MockBean
    SummaryCalculator summaryCalculator;

    @Test
    void getSummaries_ReturnsEmptyList() {
        var result = basket.getSummaries();
        var expected = List.of();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void getSummaries_Returns2Entries() {
        var result = basket.getSummaries();
        var expected = List.of();
        Assertions.assertEquals(expected, result);
        String testMail = "samuel@email.com";
        ItemSelection testSelection =
                new ItemSelection(testMail, "item1", 1.0);
        Summary testSummary = new Summary(
                testMail, "item1", 1.00, 2.50, 3.50
        );
        summaryCalculator.getSummary(testSelection);
        basket.transformItemSelection(testSelection);
        var response = basket.getSummaries();
        var expectedEntry1 = List.of(testSummary);
        Assertions.assertEquals(expectedEntry1, response);

    }

    @DirtiesContext
    @Test
    void transformItemSelection() {
        String testMail = "samuel@email.com";
        ItemSelection testSelection =
                new ItemSelection(testMail, "item1", 1.0);
        Summary testSummary = new Summary(
                testMail, "item1", 1.00, 2.50, 3.50
        );
        Mockito.when(summaryCalculator.getSummary(testSelection)).thenReturn(testSummary);
        var response = basket.getSummaries();
        var expected = List.of(testSummary);
        Mockito.verify(summaryCalculator).getSummary(testSelection);
    }
}