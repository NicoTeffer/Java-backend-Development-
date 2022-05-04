package io.everyonecodes.basket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class UsersClientTest {

    @Autowired
    UsersClient usersClient;

    @MockBean
    RestTemplate restTemplate;

    @Value("${urls.usersUrl}")
    String url;

    @Test
    void getUserFromUsersApp() {
        String testMail = "samuel@email.com";
        User expected = new User("samuel@email.com", "standard");
        Mockito.when(restTemplate.getForObject(url + "/users/" + testMail, User.class)).thenReturn(expected);
        var response = usersClient.getUserFromUsersApp(testMail);
        Assertions.assertEquals(expected, response);
        Mockito.verify(restTemplate).getForObject(url + "/users/" + testMail, User.class);
    }

    @Test
    void getUserNullForUnknownUserFromApp() {
        String testMail = "nico@email.com";
        Mockito.when(restTemplate.getForObject(url + "/users/" + testMail, User.class)).thenReturn(null);
        var response = usersClient.getUserFromUsersApp(testMail);
        Assertions.assertNull(response);
        Mockito.verify(restTemplate).getForObject(url + "/users/" + testMail, User.class);
    }
}