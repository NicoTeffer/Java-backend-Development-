package io.everyonecodes.mongo_rockscissorspaper.mongodb;

import java.util.Objects;

public class GameResult {

    private String id;
    private String result;

    public GameResult() {
    }

    public GameResult(String result) {
        this.result = result;
    }

    public GameResult(String id, String result) {
        this.id = id;
        this.result = result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResult that = (GameResult) o;
        return Objects.equals(id, that.id) && Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, result);
    }

    @Override
    public String toString() {
        return "GameResult{" +
                "id='" + id + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
