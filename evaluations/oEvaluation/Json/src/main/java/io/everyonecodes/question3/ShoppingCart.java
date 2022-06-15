package io.everyonecodes.question3;

import java.util.List;

public class ShoppingCart {

    private String customerName;
    private int discountCode;
    private List<Articles> articles;

    public ShoppingCart() {
    }

    public ShoppingCart(String customerName, int discountCode, List<Articles> articles) {
        this.customerName = customerName;
        this.discountCode = discountCode;
        this.articles = articles;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(int discountCode) {
        this.discountCode = discountCode;
    }

    public List<Articles> getArticles() {
        return articles;
    }

    public void setArticles(List<Articles> articles) {
        this.articles = articles;
    }
}
