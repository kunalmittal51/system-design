package couponsystem.entity.coupons;

import couponsystem.entity.products.Product;

public class PercentageCouponDecorator extends Product {

        private final Product product;
        private static final int percentage = 10;

        public PercentageCouponDecorator(Product product) {
            super(product.getPrice(), product.getName(), product.getProductType());
            this.product = product;
        }

        @Override
        public int getPrice() {
            return product.getPrice() - (product.getPrice() * percentage / 100);
        }
}
