package io.everyonecodes.restaurant_taxer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class BeverageTaxerTest {

    @Autowired
    BeverageTaxer beverageTaxer;

    @Test
    void taxing() {
        var result = beverageTaxer.taxing(new RestaurantDish("testBeverage",2.0));
        var expected = 2.4;
        Assertions.assertEquals(expected, result, 0.0000001);
    }
}