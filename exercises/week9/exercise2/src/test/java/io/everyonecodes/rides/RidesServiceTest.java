package io.everyonecodes.rides;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class RidesServiceTest {

    @Autowired
    RidesService ridesService;

    @MockBean
    DriverRepository driverRepository;

    @MockBean
    RidesRepository ridesRepository;

    //TODO: FUCKING MOCK THE FILTER CHAIN!!!!!!111
    @MockBean
    SecurityFilterChain securityFilterChain;


    @Test
    void postDriver() {
        Driver driver = new Driver("test", "testCar");
        Mockito.when(driverRepository.save(driver)).thenReturn(driver);

        ridesService.postDriver(driver);

        Mockito.verify(driverRepository).save(driver);
    }

    @Test
    void getAllDrivers() {
        Driver driver1 = new Driver("test1", "testCar1");
        Driver driver2 = new Driver("test2", "testCar2");
        List<Driver> driverList = List.of(driver1, driver2);
        Mockito.when(driverRepository.findAll()).thenReturn(driverList);

        ridesService.getAllDrivers();

        Mockito.verify(driverRepository).findAll();
    }

    @Test
    void postRide() {
        Driver driver = new Driver(123L, "testDriver", "testCar", new ArrayList<>());
        Rides ride = new Rides("testCustomer1", 11.11, 22.22);
        Mockito.when(driverRepository.findById(123L)).thenReturn(Optional.of(driver));
        Mockito.when(driverRepository.save(driver)).thenReturn(driver);
        Mockito.when(ridesRepository.save(ride)).thenReturn(ride);

        ridesService.postRide(123L, ride);

        Mockito.verify(driverRepository).findById(123L);
        Mockito.verify(driverRepository).save(driver);
        Mockito.verify(ridesRepository).save(ride);
    }
}