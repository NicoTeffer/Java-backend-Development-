package io.everyonecodes.steam_users;

import java.util.HashSet;
import java.util.Set;

public class User {

    private String id;
    private String username;
    private String password;
    private Set<String> authorities = new HashSet<>();

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, Set<String> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public User(String id, String username, String password, Set<String> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
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

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }
}
