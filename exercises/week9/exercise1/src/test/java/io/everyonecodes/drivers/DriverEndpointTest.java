package io.everyonecodes.drivers;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DriverEndpointTest {

    // TODO: DON'T FORGET TESTING THE UNSECURED METHODS !!!

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    DriverService driverService;

    @Value("${drivers.url}")
    String url;

    @Test
    void postDriver() {
        Driver driver = new Driver(
                "username", "password", "car");

        testRestTemplate.postForObject(url, driver, Driver[].class);

        Mockito.verify(driverService).save(driver);
    }
}