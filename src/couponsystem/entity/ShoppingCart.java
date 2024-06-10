package couponsystem.entity;

import couponsystem.entity.coupons.PercentageCouponDecorator;
import couponsystem.entity.coupons.ProductDiscount;
import couponsystem.entity.products.Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    List<Product> productList;

    public ShoppingCart() {
        this.productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public int getCardPrice() {
        int totalPrice = 0;
        for (Product product : productList) {
            totalPrice +=  product.getPrice();
        }
        return totalPrice;
    }

    public int getCartPriceAfterDiscount() {
        int totalPrice = 0;
        for (Product product : productList) {
            totalPrice += new ProductDiscount(new PercentageCouponDecorator(product)).getPrice();
        }
        return totalPrice;
    }
}
