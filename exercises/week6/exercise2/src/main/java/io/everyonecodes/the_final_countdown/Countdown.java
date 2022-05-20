package io.everyonecodes.the_final_countdown;

import java.util.Objects;

public class Countdown {

    private String id;
    private int count;

    public Countdown() {
    }

    public Countdown(int count) {
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Countdown countdown = (Countdown) o;
        return count == countdown.count && Objects.equals(id, countdown.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, count);
    }
}
