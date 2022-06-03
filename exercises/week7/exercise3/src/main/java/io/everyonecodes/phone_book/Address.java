package io.everyonecodes.phone_book;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Entity
public class Address {

    // TODO: Address. Has id as a Long property. Has street and postalCode as a String property.

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String street;

    @Max(9999)
    private String postalCode;

    public Address() {
    }

    public Address(@NotEmpty String street, @Max(9999) String postalCode) {
        this.street = street;
        this.postalCode = postalCode;
    }

    public Address(Long id, @NotEmpty String street, @Max(9999) String postalCode) {
        this.id = id;
        this.street = street;
        this.postalCode = postalCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) && Objects.equals(street, address.street) && Objects.equals(postalCode, address.postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, postalCode);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
