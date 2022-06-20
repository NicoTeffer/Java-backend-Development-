package io.everyonecodes.drivers;

import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Set;

public class Driver {

    private String id;

    @Indexed(unique = true)
    private String username;

    private String password;

    private boolean isAvailable;

    private String carType;

    private Set<String> authorities;

    public Driver() {
    }

    public Driver(String username, String password, boolean isAvailable, String carType, Set<String> authorities) {
        this.username = username;
        this.password = password;
        this.isAvailable = isAvailable;
        this.carType = carType;
        this.authorities = authorities;
    }

    public Driver(String id, String username, String password, boolean isAvailable, String carType, Set<String> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.isAvailable = isAvailable;
        this.carType = carType;
        this.authorities = authorities;
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

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }
}
