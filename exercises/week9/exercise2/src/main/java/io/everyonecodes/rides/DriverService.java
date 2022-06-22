package io.everyonecodes.rides;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {
    private final DriverRepository driverRepository;
    private final RideRepository rideRepository;

    public DriverService(DriverRepository driverRepository, RideRepository rideRepository) {
        this.driverRepository = driverRepository;
        this.rideRepository = rideRepository;
    }

    public List<Driver> findAll() {
        return driverRepository.findAll();
    }

    public Driver save(Driver driver) {
        return driverRepository.save(driver);
    }

    public Ride link(Long id, Ride ride) {
        Optional<Driver> oDriver = driverRepository.findById(id);
        if (oDriver.isEmpty()) {
            return ride;
        }
        rideRepository.save(ride);
        Driver driver = oDriver.get();
        driver.getRides().add(ride);
        driverRepository.save(driver);
        return ride;
    }
}