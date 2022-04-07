package io.everyonecodes.restaurant_taxer;

import java.util.List;

public abstract class Taxer {

    private final List<String> dishNames;
    private final double tax;

    public Taxer(List<String> dishNames, double tax) {
        this.dishNames = dishNames;
        this.tax = tax;
    }

    public List<String> getDishNames() {
        return dishNames;
    }

    public double getTax() {
        return tax;
    }

    public boolean matches(RestaurantDish dish) {
        return dishNames.contains(dish.getName());
    }

    public abstract double taxing(RestaurantDish dish);
}
