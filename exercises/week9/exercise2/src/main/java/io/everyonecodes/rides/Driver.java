package io.everyonecodes.rides;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Objects;

@Entity
public class Driver {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    @NotEmpty
    private String username;

    @NotEmpty
    private String carType;

    @OneToMany
    private List<Rides> ridesList;

    public Driver() {
    }

    public Driver(@NotEmpty String username, @NotEmpty String carType) {
        this.username = username;
        this.carType = carType;
    }

    public Driver(@NotEmpty String username, @NotEmpty String carType, List<Rides> ridesList) {
        this.username = username;
        this.carType = carType;
        this.ridesList = ridesList;
    }

    public Driver(Long id, @NotEmpty String username, @NotEmpty String carType, List<Rides> ridesList) {
        this.id = id;
        this.username = username;
        this.carType = carType;
        this.ridesList = ridesList;
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

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public List<Rides> getRidesList() {
        return ridesList;
    }

    public void setRidesList(List<Rides> ridesList) {
        this.ridesList = ridesList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return Objects.equals(id, driver.id) && Objects.equals(username, driver.username) && Objects.equals(carType, driver.carType) && Objects.equals(ridesList, driver.ridesList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, carType, ridesList);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", carType='" + carType + '\'' +
                ", ridesList=" + ridesList +
                '}';
    }
}
