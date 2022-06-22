package io.everyonecodes.rides;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.web.SecurityFilterChain;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class DriverServiceTest {
    @Autowired
    DriverService driverService;

    @MockBean
    DriverRepository driverRepository;

    @MockBean
    RideRepository rideRepository;

    @MockBean
    SecurityFilterChain securityFilterChain;

    @Value("${driver.username")
    String username;

    @Value("${driver.vehicle")
    String vehicle;

    @Value("${ride.customer}")
    String customer;

    @Value("${ride.distance}")
    int distance;

    @Value("${ride.price}")
    double price;

    @Value("${random.long}")
    Long longId;

    @Test
    void findAll() {
        driverService.findAll();

        Mockito.verify(driverRepository).findAll();
    }

    @Test
    void save() {
        Driver driver = new Driver(username, vehicle);

        driverService.save(driver);

        Mockito.verify(driverRepository).save(driver);
    }

    @Test
    void linkDoesNotFindDriver() {

        Ride ride = new Ride(customer, distance, price);
        Mockito.when(driverRepository.findById(longId)).thenReturn(Optional.empty());

        driverService.link(longId, ride);

        Mockito.verify(driverRepository).findById(longId);
        Mockito.verifyNoMoreInteractions(driverRepository);
        Mockito.verifyNoInteractions(rideRepository);
    }

    @Test
    void linkDoesFindsDriver() {

        Driver driver = new Driver(username, vehicle, new HashSet<>());
        Mockito.when(driverRepository.findById(longId)).thenReturn(Optional.of(driver));
        Ride ride = new Ride(customer, distance, price);

        driverService.link(longId, ride);

        Mockito.verify(driverRepository).findById(longId);
        Mockito.verify(rideRepository).save(ride);
        Driver expected = new Driver(username, vehicle, Set.of(ride));
        Mockito.verify(driverRepository).save(expected);
    }

}