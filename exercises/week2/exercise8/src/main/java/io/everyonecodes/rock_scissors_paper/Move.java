package io.everyonecodes.rock_scissors_paper;

public class Move {

    private String name;
    private String defeats;

    public Move() {
    }

    public Move(String name, String defeats) {
        this.name = name;
        this.defeats = defeats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefeats() {
        return defeats;
    }

    public void setDefeats(String defeats) {
        this.defeats = defeats;
    }
}
