package inventorymanangementservice.entity;

import java.util.ArrayList;
import java.util.List;

public class ProductCategory {
    int id;
    String categoryName;
    List<Product> productList;
    int price;

    public ProductCategory(int id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
        this.productList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }
}
