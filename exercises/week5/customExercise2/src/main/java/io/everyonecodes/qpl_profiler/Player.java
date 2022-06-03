package io.everyonecodes.qpl_profiler;

import java.util.Objects;

public class Player {

    private String id;
    private String name;
    private int age;
    private String country;
    private String status;
    private String team;
    private int totalEarnings;

    public Player() {
    }

    public Player(String name, int age, String country, String status, String team, int totalEarnings) {
        this.name = name;
        this.age = age;
        this.country = country;
        this.status = status;
        this.team = team;
        this.totalEarnings = totalEarnings;
    }

    public Player(String id, String name, int age, String country, String status, String team, int totalEarnings) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.country = country;
        this.status = status;
        this.team = team;
        this.totalEarnings = totalEarnings;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getTotalEarnings() {
        return totalEarnings;
    }

    public void setTotalEarnings(int totalEarnings) {
        this.totalEarnings = totalEarnings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return age == player.age && totalEarnings == player.totalEarnings && Objects.equals(id, player.id) && Objects.equals(name, player.name) && Objects.equals(country, player.country) && Objects.equals(status, player.status) && Objects.equals(team, player.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, country, status, team, totalEarnings);
    }

    @Override
    public String toString() {
        return "Player{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                ", status='" + status + '\'' +
                ", team='" + team + '\'' +
                ", totalEarnings=" + totalEarnings +
                '}';
    }
}
