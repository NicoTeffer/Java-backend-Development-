package io.everyonecodes.users;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserEndpointTest {
    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    UserStore userStore;

    String url = "/users/";

    @Test
    void get_returnsUnknownUser() {
        String testMail = "test5mail";
        Mockito.when(userStore.getUser(testMail)).thenReturn(null);
        var response = testRestTemplate.getForObject(url + testMail, User.class);
        Assertions.assertNull(response);
        Mockito.verify(userStore).getUser(testMail);
    }

    @Test
    void get_validUser() {
        User expected = new User("test3", "test3mail", "premium");
        String testMail = "test3mail";
        Mockito.when(userStore.getUser(testMail)).thenReturn(expected);
        var response = testRestTemplate.getForObject(url + testMail, User.class);
        Assertions.assertEquals(expected, response);
        Mockito.verify(userStore).getUser(testMail);
    }
}