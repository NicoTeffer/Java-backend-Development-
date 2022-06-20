package io.everyonecodes.rides;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class RidesEndpoint {

    private final RidesService ridesService;

    public RidesEndpoint(RidesService ridesService) {
        this.ridesService = ridesService;
    }

    //TODO:POST a Driver to “/drivers” -> saves the Driver and returns it [for admins only]
    @PostMapping("/drivers")
    @Secured("ROLE_ADMIN")
    Driver postDriver(@RequestBody Driver driver) {
        return ridesService.postDriver(driver);
    }

    //TODO: GET to “/drivers” -> returns all Driver entries [for admins only]
    @GetMapping("/drivers")
    @Secured("ROLE_ADMIN")
    List<Driver> getAllDrivers() {
        return ridesService.getAllDrivers();
    }

    //TODO: POST a Ride to “/drivers/{id}/rides” -> saves the Ride,
    // links it to the Driver that matches the id, and returns the Ride [for apps only]
    @PostMapping("/drivers/{id}/rides")
    @Secured("ROLE_APP")
    Rides postRide(@PathVariable Long id, @RequestBody Rides ride) {
        return ridesService.postRide(id, ride);
    }
}
