package fullfillmentservice;

import fullfillmentservice.entity.Inventory;

public class DriverClass {
    public static void main(String args[]){
        System.out.println("Initializing the full-fillment service");

        Inventory inventory = new Inventory();
        inventory.addItems(1, 10);
        inventory.addItems(2, 20);
        inventory.addItems(3, 30);
        inventory.displayInventory();
        inventory.removeItems(1,4);
        inventory.displayInventory();
    }

}
