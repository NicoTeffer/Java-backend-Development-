package io.everyonecodes.restaurant_taxer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
class BillCalculatorTest {

    @Autowired
    BillCalculator billCalculator;

    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                new RestaurantDish("soda", 2.0),
                                new RestaurantDish("tiramisu", 10.0)
                        ), 13.40),
                Arguments.of(
                        List.of(new RestaurantDish("tiramisu", 10.0),
                                new RestaurantDish("potato soup", 6.0),
                                new RestaurantDish("caesar salad", 4.0),
                                new RestaurantDish("soda", 2.0),
                                new RestaurantDish("orange juice", 3.0),
                                new RestaurantDish("milkshake", 5.0),
                                new RestaurantDish("spaghetti", 11.0)
                        ), 45.00)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void calculate(List<RestaurantDish> dishList, double totalPrice) {
        var result = billCalculator.calculate(dishList);
        Assertions.assertEquals(totalPrice, result, 0.0000001);
    }
}