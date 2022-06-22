package io.everyonecodes.rides;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverEndpoint {
    private final DriverService driverService;

    public DriverEndpoint(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping
    @Secured("ROLE_ADMIN")
    List<Driver> get() {
        return driverService.findAll();
    }

    @PostMapping
    @Secured("ROLE_ADMIN")
    Driver post(@RequestBody Driver driver) {
        return driverService.save(driver);
    }

    @PostMapping("/{id}/rides")
    @Secured("ROLE_APP")
    Ride ride(@PathVariable Long id, @RequestBody Ride ride) {
        return driverService.link(id, ride);
    }
}