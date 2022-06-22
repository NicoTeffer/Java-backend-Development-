package io.everyonecodes.rides;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Ride {
    @Id
    @GeneratedValue
    private Long id;

    private String customer;
    private int distance;
    private double price;

    public Ride() {
    }

    public Ride(String customer, int distance, double price) {
        this.customer = customer;
        this.distance = distance;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ride ride = (Ride) o;
        return distance == ride.distance && Double.compare(ride.price, price) == 0 && Objects.equals(id, ride.id) && Objects.equals(customer, ride.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, distance, price);
    }
}
