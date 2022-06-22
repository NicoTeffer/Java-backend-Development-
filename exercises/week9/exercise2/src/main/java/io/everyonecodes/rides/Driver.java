package io.everyonecodes.rides;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;

@Entity
public class Driver {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String username;

    private String vehicle;

    @OneToMany(fetch = EAGER)
    private Set<Ride> rides = new HashSet<>();

    public Driver() {
    }

    public Driver(String username, String vehicle) {
        this.username = username;
        this.vehicle = vehicle;
    }

    public Driver(String username, String vehicle, Set<Ride> rides) {
        this.username = username;
        this.vehicle = vehicle;
        this.rides = rides;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public Set<Ride> getRides() {
        return rides;
    }

    public void setRides(Set<Ride> rides) {
        this.rides = rides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return Objects.equals(id, driver.id) && Objects.equals(username, driver.username) && Objects.equals(vehicle, driver.vehicle) && Objects.equals(rides, driver.rides);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, vehicle, rides);
    }
}
