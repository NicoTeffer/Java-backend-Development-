package io.everyonecodes.steam_purchases;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;

@Entity
public class GameUser {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    private Set<String> authorities = new HashSet<>();

    public GameUser(String username, String password, Set<String> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public GameUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public GameUser() {
    }

    public GameUser(Long id, String username, String password, Set<String> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public GameUser(String username) {
        this.username = username;
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
