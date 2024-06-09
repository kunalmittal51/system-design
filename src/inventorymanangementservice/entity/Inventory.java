package inventorymanangementservice.entity;

import java.util.List;

public class Inventory {
    List<ProductCategory> productCategoryList;

    public Inventory(List<ProductCategory> productCategoryList) {
        this.productCategoryList = productCategoryList;
    }

    public List<ProductCategory> getProductCategoryList() {
        return productCategoryList;
    }

    public void setProductCategoryList(List<ProductCategory> productCategoryList) {
        this.productCategoryList = productCategoryList;
    }
}
