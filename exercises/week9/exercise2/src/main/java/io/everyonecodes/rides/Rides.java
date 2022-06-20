package io.everyonecodes.rides;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Entity
public class Rides {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String customerUserName;


    private double distanceTraveled;


    private double price;

    public Rides() {
    }

    public Rides(Long id, @NotEmpty String customerUserName, double distanceTraveled, double price) {
        this.id = id;
        this.customerUserName = customerUserName;
        this.distanceTraveled = distanceTraveled;
        this.price = price;
    }

    public Rides(@NotEmpty String customerUserName, double distanceTraveled, double price) {
        this.customerUserName = customerUserName;
        this.distanceTraveled = distanceTraveled;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerUserName() {
        return customerUserName;
    }

    public void setCustomerUserName(String customerUserName) {
        this.customerUserName = customerUserName;
    }

    public double getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(double distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
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
        Rides rides = (Rides) o;
        return Double.compare(rides.distanceTraveled, distanceTraveled) == 0 && Double.compare(rides.price, price) == 0 && Objects.equals(id, rides.id) && Objects.equals(customerUserName, rides.customerUserName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerUserName, distanceTraveled, price);
    }

    @Override
    public String toString() {
        return "Rides{" +
                "id=" + id +
                ", customerUserName='" + customerUserName + '\'' +
                ", distanceTraveled=" + distanceTraveled +
                ", price=" + price +
                '}';
    }
}
