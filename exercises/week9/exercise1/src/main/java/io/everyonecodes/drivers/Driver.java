package io.everyonecodes.drivers;

import java.util.Objects;
import java.util.Set;

public class Driver {

    private String id;
    private String username;
    private String password;
    private Set<String> authorities;
    private String vehicle;
    private boolean available;

    public Driver() {
    }

    public Driver(String username, String password, Set<String> authorities, String vehicle, boolean available) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.vehicle = vehicle;
        this.available = available;
    }

    public Driver(String username, String password, String vehicle) {
        this.username = username;
        this.password = password;
        this.vehicle = vehicle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return available == driver.available && Objects.equals(id, driver.id) && Objects.equals(username, driver.username) && Objects.equals(password, driver.password) && Objects.equals(authorities, driver.authorities) && Objects.equals(vehicle, driver.vehicle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, authorities, vehicle, available);
    }
}
