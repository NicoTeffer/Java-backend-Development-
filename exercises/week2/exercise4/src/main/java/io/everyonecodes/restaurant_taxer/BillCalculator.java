package io.everyonecodes.restaurant_taxer;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BillCalculator {

    private final Set<Taxer> taxers;

    public BillCalculator(FoodstuffTaxer foodstuffTaxer, BeverageTaxer beverageTaxer) {
        taxers = Set.of(foodstuffTaxer, beverageTaxer);
    }

    public double calculate(List<RestaurantDish> dishes) {
        return dishes.stream()
                .mapToDouble(dish -> taxers.stream()
                        .filter(taxer -> taxer.matches(dish))
                        .map(taxer -> taxer.taxing(dish))
                        .reduce(Double::sum)
                        .orElse(dish.getPrice()))
                .sum();
    }
}