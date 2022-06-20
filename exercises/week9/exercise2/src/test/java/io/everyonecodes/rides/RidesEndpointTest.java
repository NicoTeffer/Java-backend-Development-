package io.everyonecodes.rides;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RidesEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    RidesService ridesService;

    String url = "/drivers";

    @MockBean
    SecurityFilterChain securityFilterChain;

    @MockBean
    UserDetailsService userDetailsService;

    @MockBean
    PasswordEncoder passwordEncoder;

    @Test
    void postDriver() {
        Driver driver = new Driver("test", "testCar");

        testRestTemplate.postForObject(url, driver, Driver[].class);

        Mockito.verify(ridesService).postDriver(driver);
    }

    @Test
    void getAllDrivers() {
        testRestTemplate.getForObject(url, Driver[].class);

        Mockito.verify(ridesService).getAllDrivers();
    }

    @Test
    void postRide() {
        String id = "12";
        Long idL = 12L;
        Rides ride = new Rides("test", 12.21, 21.21);

        testRestTemplate.postForObject(url + "/" + id + "/rides", ride, Rides[].class);

        Mockito.verify(ridesService).postRide(idL, ride);
    }
}