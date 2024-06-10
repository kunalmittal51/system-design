package couponsystem.entity.products;

import couponsystem.enums.ProductType;

public class Item extends Product {

    public Item(int price, String name, ProductType productType) {
        super(price, name, productType);
    }

    @Override
    public int getPrice() {
        return price;
    }
}
