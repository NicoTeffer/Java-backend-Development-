package io.everyonecodes.music_station;

import java.util.Objects;

public class Song {

    private String name, genre;

    public Song() {
    }

    public Song(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(name, song.name) && Objects.equals(genre, song.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, genre);
    }
}
