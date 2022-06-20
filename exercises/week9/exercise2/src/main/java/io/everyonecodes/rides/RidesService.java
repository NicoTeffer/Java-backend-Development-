package io.everyonecodes.rides;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RidesService {

    private final DriverRepository driverRepository;

    private final RidesRepository ridesRepository;


    public RidesService(DriverRepository driverRepository, RidesRepository ridesRepository) {
        this.driverRepository = driverRepository;
        this.ridesRepository = ridesRepository;
    }

    //TODO: POST a Driver to “/drivers” -> saves the Driver and returns it [for admins only]
    public Driver postDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    //TODO: GET to “/drivers” -> returns all Driver entries [for admins only]
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    //TODO: POST a Ride to “/drivers/{id}/rides” -> saves the Ride, links it to the Driver that matches the id,
    // and returns the Ride [for apps only]
    public Rides postRide(Long id, Rides ride) {
        var rideSaved = ridesRepository.save(ride);
        var driverForRide = driverRepository.findById(id);
        driverForRide.get().getRidesList().add(ride);
        driverRepository.save(driverForRide.get());
        return rideSaved;
    }
}
