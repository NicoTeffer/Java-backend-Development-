package io.everyonecodes.steam_purchases;

public class Purchase {

    private String username;
    private String gameName;
    private String identifier;
    private double price;

    public Purchase(String username, String gameName, String identifier, double price) {
        this.username = username;
        this.gameName = gameName;
        this.identifier = identifier;
        this.price = price;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
}
