package io.everyonecodes.restaurant_taxer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class FoodstuffTaxerTest {

    @Autowired
    FoodstuffTaxer foodstuffTaxer;

    @Test
    void taxing() {
        var result = foodstuffTaxer.taxing(new RestaurantDish("testFoodstuff",3.0));
        var expected = 3.3;
        Assertions.assertEquals(expected, result, 0.0000001);
    }
}