package io.everyonecodes.restaurant_taxer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodstuffTaxer extends Taxer {

    public FoodstuffTaxer(
            @Value("${restaurant.foodstuff.names}") List<String> dishNames,
            @Value("${restaurant.foodstuff.tax}") double tax
    ) {
        super(dishNames, tax);
    }

    @Override
    public double taxing(RestaurantDish dish) {
        return dish.getPrice() * super.getTax();
    }

}