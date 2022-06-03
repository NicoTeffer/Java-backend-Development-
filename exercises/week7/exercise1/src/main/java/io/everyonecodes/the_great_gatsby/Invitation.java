package io.everyonecodes.the_great_gatsby;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Entity
public class Invitation {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String name;

    public Invitation() {
    }

    public Invitation(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Invitation(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invitation that = (Invitation) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Invitation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
