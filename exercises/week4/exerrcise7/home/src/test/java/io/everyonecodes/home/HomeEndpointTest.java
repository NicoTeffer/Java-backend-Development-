package io.everyonecodes.home;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HomeEndpointTest {

    @Autowired
    HomeEndpoint homeEndpoint;

    @Test
    void getKansas() {
        var response = homeEndpoint.getKansas();
        var expected = "Kansas";
        Assertions.assertEquals(expected, response);
    }
}