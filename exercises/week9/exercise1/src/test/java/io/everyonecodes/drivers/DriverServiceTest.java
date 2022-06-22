package io.everyonecodes.drivers;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Optional;
import java.util.Set;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class DriverServiceTest {

    //TODO: DON'T FORGET THE TEST YAML!!!

    @Autowired
    DriverService driverService;

    @MockBean
    DriverRepository driverRepository;

    @Value("${drivers.authorities}")
    Set<String> authorities;

    @MockBean
    SecurityFilterChain securityFilterChain;


    @Test
    void saveFindsExistingDriver() {
        String username = "username";
        Driver driver = new Driver(username, "password", "test car");
        Mockito.when(driverRepository.findOneByUsername(username)).thenReturn(Optional.of(driver));

        driverService.save(driver);

        Mockito.verify(driverRepository).findOneByUsername(username);
        Mockito.verifyNoMoreInteractions(driverRepository);
    }

    @Test
    void saveCreatesNewDriver() {
        String username = "username";
        Mockito.when(driverRepository.findOneByUsername(username)).thenReturn(Optional.empty());
        Driver driver = new Driver(username, "password", "test car");

        driverService.save(driver);

        Mockito.verify(driverRepository).findOneByUsername(username);
        Mockito.verify(driverRepository).save(driver);
    }

    @Test
    void findOneBy() {
        String id = "id";

        driverService.findOneBy(id);

        Mockito.verify(driverRepository).findById(id);
    }

    @Test
    void tagAsAvailableFindsDriver() {
        String id = "id";
        Driver driver = new Driver(
                "username", "password", authorities, "car", false);
        Mockito.when(driverRepository.findById(id)).thenReturn(Optional.of(driver));

        driverService.tagAsAvailable(id);

        Mockito.verify(driverRepository).findById(id);
        Driver expected = new Driver(
                "username", "password", authorities, "car", true);
        Mockito.verify(driverRepository).save(expected);
    }

    @Test
    void tagAsAvailableDoesNotFindDriver() {
        String id = "id";
        Mockito.when(driverRepository.findById(id)).thenReturn(Optional.empty());

        driverService.tagAsAvailable(id);

        Mockito.verify(driverRepository).findById(id);
        Mockito.verifyNoMoreInteractions(driverRepository);
    }

    @Test
    void tagAsUnavailableFindsDriver() {
        String id = "id";
        Driver driver = new Driver(
                "username", "password", authorities, "car", true);
        Mockito.when(driverRepository.findById(id)).thenReturn(Optional.of(driver));

        driverService.tagAsUnavailable(id);

        Mockito.verify(driverRepository).findById(id);
        Driver expected = new Driver(
                "username", "password", authorities, "car", false);
        Mockito.verify(driverRepository).save(expected);
    }

    @Test
    void tagAsUnavailableDoesNotFindDriver() {
        String id = "id";
        Mockito.when(driverRepository.findById(id)).thenReturn(Optional.empty());

        driverService.tagAsUnavailable(id);

        Mockito.verify(driverRepository).findById(id);
        Mockito.verifyNoMoreInteractions(driverRepository);
    }
}