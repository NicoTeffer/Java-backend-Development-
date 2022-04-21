package io.everyonecodes.json_placeholder;

import java.util.Objects;

public class PostDTO {

    // ⭔	PostDTO. Has title and body as String properties, and userId and id as int properties.
    private int id, userId;
    private String title, body;

    public PostDTO() {
    }

    public PostDTO(int id, int userId, String title, String body) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostDTO postDTO = (PostDTO) o;
        return userId == postDTO.userId && id == postDTO.id && Objects.equals(title, postDTO.title) && Objects.equals(body, postDTO.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, body, userId, id);
    }
}
