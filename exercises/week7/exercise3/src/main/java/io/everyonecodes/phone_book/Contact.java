package io.everyonecodes.phone_book;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Entity
public class Contact {

    //TODO: Contact. Has id as a Long property. Has name as a String property.
    // Has address as an Address property with a one to one relationship.

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String name;

    @OneToOne
    private Address address;

    public Contact() {
    }

    public Contact(Long id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Contact(String name, Address address) {
        this.name = name;
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(id, contact.id) && Objects.equals(name, contact.name) && Objects.equals(address, contact.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
