package couponsystem.entity.coupons;

import couponsystem.entity.products.Product;
import couponsystem.enums.ProductType;

public abstract class CouponDecorator extends Product {

    protected Product product;

    public CouponDecorator(Product product) {
        super(product.getPrice(), product.getName(), product.getProductType());
        this.product = product;
    }

    @Override
    public int getPrice() {
        return product.getPrice();
    }

    @Override
    public String getName() {
        return product.getName();
    }

    @Override
    public ProductType getProductType() {
        return product.getProductType();
    }
}
