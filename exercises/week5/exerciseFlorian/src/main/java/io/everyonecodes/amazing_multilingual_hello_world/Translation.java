package io.everyonecodes.amazing_multilingual_hello_world;

import java.util.Objects;

public class Translation {

    private String language;
    private String text;

    public Translation() {
    }

    public Translation(String language, String text) {
        this.language = language;
        this.text = text;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Translation that = (Translation) o;
        return Objects.equals(language, that.language) && Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(language, text);
    }
}
