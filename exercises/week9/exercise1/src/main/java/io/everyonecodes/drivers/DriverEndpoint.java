package io.everyonecodes.drivers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/drivers")
public class DriverEndpoint {

    // TODO: DON'T FORGET TESTING THE UNSECURED METHODS !!!
    private final DriverService driverService;

    public DriverEndpoint(DriverService driverService) {
        this.driverService = driverService;
    }

    //TODO: Post a Driver to “/drivers” -> processes the Driver, saves it in the database and returns it [available to everyone]
    @PostMapping
    Driver postDriver(@RequestBody Driver driver) {
        return driverService.save(driver);
    }

    //TODO: GET to “/drivers/{id}” -> returns the Driver with the matching id [for drivers only]
    @GetMapping("/{id}")
    @Secured("ROLE_DRIVER")
    Driver getDriverById(@PathVariable String id) {
        return driverService.findOneBy(id).orElse(null);
    }

    //TODO: PUT to “/drivers/{id}/available” -> tags the Driver with the matching id as available [for drivers only]
    @PutMapping("/{id}/available")
    @Secured("ROLE_DRIVER")
    void makeAvailable(@PathVariable String id) {
        driverService.tagAsAvailable(id);
    }

    //TODO: PUT to “/drivers/{id}/unavailable” -> tags the Driver with the matching id as not available [for drivers only]
    @PutMapping("/{id}/unavailable")
    void makeUnavailable(@PathVariable String id) {
        driverService.tagAsUnavailable(id);
    }
}
