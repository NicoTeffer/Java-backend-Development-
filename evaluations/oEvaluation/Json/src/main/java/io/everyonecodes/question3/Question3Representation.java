package io.everyonecodes.question3;

import com.google.gson.Gson;

import java.util.List;

public class Question3Representation {
    public static ShoppingCart getCart(ShoppingCart shoppingCart) {
        shoppingCart.setCustomerName("Josh");
        shoppingCart.setDiscountCode(1234);
        shoppingCart.setArticles(List.of(
                new Articles("Tea Thermo", 12.95),
                new Articles("Water Boiler", 21.95)
        ));
        return shoppingCart;
    }

    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        getCart(shoppingCart);
        System.out.println("The JSON representation of Object shoppingCart is: ");
        System.out.println(new Gson().toJson(shoppingCart));
    }
}
