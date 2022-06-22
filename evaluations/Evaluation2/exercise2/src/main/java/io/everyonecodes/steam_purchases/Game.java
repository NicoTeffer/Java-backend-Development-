package io.everyonecodes.steam_purchases;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;

@Entity
public class Game {

    @Id
    @GeneratedValue
    private Long id;

    private String gameName;

    @Column(unique = true)
    private String identifier;

    private double price;

    @OneToMany(fetch = EAGER)
    private Set<GameUser> gameUsers = new HashSet<>();

    public Game() {
    }

    public Game(String gameName, String identifier, double price) {
        this.gameName = gameName;
        this.identifier = identifier;
        this.price = price;
    }

    public Game(String gameName, String identifier, double price, Set<GameUser> gameUsers) {
        this.gameName = gameName;
        this.identifier = identifier;
        this.price = price;
        this.gameUsers = gameUsers;
    }

    public Game(Long id, String gameName, String identifier, double price, Set<GameUser> gameUsers) {
        this.id = id;
        this.gameName = gameName;
        this.identifier = identifier;
        this.price = price;
        this.gameUsers = gameUsers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<GameUser> getGameUsers() {
        return gameUsers;
    }

    public void setGameUsers(Set<GameUser> gameUsers) {
        this.gameUsers = gameUsers;
    }
}
