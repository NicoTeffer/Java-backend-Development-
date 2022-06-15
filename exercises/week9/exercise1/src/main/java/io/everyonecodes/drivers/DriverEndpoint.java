package io.everyonecodes.drivers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class DriverEndpoint {

    private final DriverRepository driverRepository;

    private final DriverService driverService;

    public DriverEndpoint(DriverRepository driverRepository, DriverService driverService) {
        this.driverRepository = driverRepository;
        this.driverService = driverService;
    }

    //TODO: Post a Driver to “/drivers” -> processes the Driver, saves it in the database and returns it [available to everyone]
    @PostMapping("/drivers")
    Driver postDriver(@RequestBody Driver driver) {
        var newDriver = driverService.makeDriver(driver);
        return driverRepository.save(newDriver);
    }

    //TODO: GET to “/drivers/{id}” -> returns the Driver with the matching id [for drivers only]
    @GetMapping("/drivers/{id}")
    @Secured("ROLE_DRIVER")
    Optional<Driver> getDriverById(@PathVariable String id) {
        return driverRepository.findById(id);
    }

    //TODO: PUT to “/drivers/{id}/available” -> tags the Driver with the matching id as available [for drivers only]
    @PutMapping("/drivers/{id}/available")
    @Secured("ROLE_DRIVER")
    void makeAvailable(@PathVariable String id) {
        driverService.makeDriverAvailable(id);
    }

    //TODO: PUT to “/drivers/{id}/unavailable” -> tags the Driver with the matching id as not available [for drivers only]
    @PutMapping("/drivers/{id}/unavailable")
    void makeUnavailable(@PathVariable String id){
        driverService.makeDriverNotAvailable(id);
    }
}
