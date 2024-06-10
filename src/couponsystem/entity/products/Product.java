package couponsystem.entity.products;

import couponsystem.enums.ProductType;

public abstract class Product {
    int price;
    String name;
    ProductType productType;

    public Product(int price, String name, ProductType productType) {
        this.price = price;
        this.name = name;
        this.productType = productType;
    }

    public abstract int getPrice();

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
}
