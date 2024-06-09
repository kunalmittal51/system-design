package inventorymanangementservice.entity;

public class WareHouse {
    Inventory inventory;
    Address address;

    public WareHouse(Inventory inventory, Address address) {
        this.inventory = inventory;
        this.address = address;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void displayInventory() {
        System.out.println("We have the following products in our inventory: ");
        for (ProductCategory productCategory : inventory.getProductCategoryList()) {
            System.out.println("Category: " + productCategory.getCategoryName() + " Price: " + productCategory.getPrice() + " ID: " + productCategory.getId());
            for (Product product : productCategory.getProductList()) {
                System.out.println("Product: " + product.getName());
            }
        }
        System.out.println("Inventory displayed successfully.");
    }

}
