package io.everyonecodes.rides;

import javax.persistence.*;

@Entity
public class Driver {

    @Id
    @GeneratedValue
    private String id;

    @Column(unique = true)
    private String username;

    private String carType;

    public Driver(String id, String username, String carType) {
        this.id = id;
        this.username = username;
        this.carType = carType;
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

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }
}
