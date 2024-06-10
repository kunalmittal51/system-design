package couponsystem.entity.coupons;

import couponsystem.entity.products.Product;
import couponsystem.enums.ProductType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductDiscount extends Product {
    Product product;
    int discount = 10;
    List<ProductType> discountableProducts =
            new ArrayList<>(Arrays.asList(ProductType.BOOKS, ProductType.FASHION));

    public ProductDiscount(Product product) {
        super(product.getPrice(), product.getName(), product.getProductType());
        this.product = product;
    }

    @Override
    public int getPrice() {
        if (discountableProducts.contains(product.getProductType())) {
            return product.getPrice() - discount;
        }
        return product.getPrice();
    }
}
