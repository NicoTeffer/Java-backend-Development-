package io.everyonecodes.drivers;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class DriverService {

    private final DriverRepository driverRepository;

    private final PasswordEncoder passwordEncoder;

    public DriverService(DriverRepository driverRepository, PasswordEncoder passwordEncoder) {
        this.driverRepository = driverRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Driver makeDriver(Driver driver) {
        String driverName = driver.getUsername();
        String driverPassword = driver.getPassword();
        Optional<Driver> existingUser;
        if (!driverRepository.existsByUsername(driverName)) {
            String password = passwordEncoder.encode(driverPassword);
            return new Driver(
                    driverName, password, false, driver.getCarType(), Set.of("ROLE_DRIVER")
            );
        }
        existingUser = driverRepository.findOneByUsername(driverName);
        return existingUser.get();
    }

    public void makeDriverAvailable(String id) {
        var driver = driverRepository.findById(id);
        driver.ifPresent(value -> value.setAvailable(true));
    }

    public void makeDriverNotAvailable(String id) {
        var driver = driverRepository.findById(id);
        driver.ifPresent(value -> value.setAvailable(false));
    }
}
