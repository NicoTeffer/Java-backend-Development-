package io.everyonecodes.basket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class SummaryCalculatorTest {

    @Autowired
    SummaryCalculator summaryCalculator;

    @MockBean
    UsersClient usersClient;

    @Test
    void getSummary_Premium() {
        String testMail = "samuel@email.com";
        Summary testSummary = new Summary(
                testMail, "item1", 1.00, 0, 1.00
        );
        ItemSelection testSelection =
                new ItemSelection("samuel@email.com", "item1", 1.0);
        User testUser = new User(testMail, "premium account");
        Mockito.when(usersClient.getUserFromUsersApp(testMail)).thenReturn(testUser);
        var response = summaryCalculator.getSummary(testSelection);
        Assertions.assertEquals(testSummary, response);
        Mockito.verify(usersClient).getUserFromUsersApp(testMail);
    }

    @Test
    void getSummary_Standard() {
        String testMail = "lisa@email.com";
        Summary testSummary = new Summary(
                testMail, "item1", 1.00, 2.50, 3.50
        );
        ItemSelection testSelection =
                new ItemSelection("lisa@email.com", "item1", 1.0);
        User testUser = new User(testMail, "standard account");
        Mockito.when(usersClient.getUserFromUsersApp(testMail)).thenReturn(testUser);
        var response = summaryCalculator.getSummary(testSelection);
        Assertions.assertEquals(testSummary, response);
        Mockito.verify(usersClient).getUserFromUsersApp(testMail);
    }
}