package io.everyonecodes.restaurant_taxer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeverageTaxer extends Taxer {

    public BeverageTaxer(
            @Value("${restaurant.beverages.names}") List<String> dishNames,
            @Value("${restaurant.beverages.tax}") double tax
    ) {
        super(dishNames, tax);
    }

    @Override
    public double taxing(RestaurantDish dish) {
        return dish.getPrice() * super.getTax();
    }

}