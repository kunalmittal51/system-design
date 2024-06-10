package couponsystem.entity;

import couponsystem.entity.products.Item;
import couponsystem.entity.products.Product;
import couponsystem.enums.ProductType;

public class DriverClass {
    public static void main(String[] args) {
        Product item = new Item(100, "item", ProductType.FASHION);
        Product item1 = new Item(200, "item", ProductType.GROCERIES);
        System.out.println("Item Price: " +  item.getPrice());
        System.out.println("Item Price1: " + item1.getPrice());

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addProduct(item);
        shoppingCart.addProduct(item1);

        int priceBeforeDiscount = shoppingCart.getCardPrice();
        System.out.println("Price after discount: " + priceBeforeDiscount);

        int priceAfterDiscount = shoppingCart.getCartPriceAfterDiscount();
        System.out.println("Price after discount: " + priceAfterDiscount);
    }
}
