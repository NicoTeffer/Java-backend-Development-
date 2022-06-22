package io.everyonecodes.drivers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class DriverService {

    private final DriverRepository driverRepository;
    private final PasswordEncoder passwordEncoder;
    private final Set<String> authorities;

    public DriverService(DriverRepository driverRepository,
                         PasswordEncoder passwordEncoder,
                         @Value("${drivers.authorities}") Set<String> authorities
    ) {
        this.driverRepository = driverRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorities = authorities;
    }

    public Driver save(Driver driver) {
        return driverRepository.findOneByUsername(driver.getUsername()).orElseGet(
                () -> create(driver));
    }

    private Driver create(Driver driver) {
        String encoded = passwordEncoder.encode(driver.getPassword());
        driver.setPassword(encoded);
        driver.setAuthorities(authorities);
        return driverRepository.save(driver);
    }

    public Optional<Driver> findOneBy(String id) {
        return driverRepository.findById(id);
    }

    public void tagAsAvailable(String id) {
        Optional<Driver> oDriver = driverRepository.findById(id);
        if (oDriver.isEmpty()) {
            return;
        }
        Driver driver = oDriver.get();
        driver.setAvailable(true);
        driverRepository.save(driver);
    }

    public void tagAsUnavailable(String id) {
        Optional<Driver> oDriver = driverRepository.findById(id);
        if (oDriver.isEmpty()) {
            return;
        }
        Driver driver = oDriver.get();
        driver.setAvailable(false);
        driverRepository.save(driver);
    }
}
