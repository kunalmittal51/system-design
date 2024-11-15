package fullfillmentservice.entity;

import java.util.HashMap;

public class Inventory {
    HashMap<Integer, Integer> inventory;

    public Inventory() {
        inventory = new HashMap<>();
    }

    public void addItems(int itemId, int quantity) {
        inventory.put(itemId, quantity);
    }

    public void removeItems(int itemId, int quantity) {
        if (inventory.containsKey(itemId)) {
            int currentQuantity = inventory.get(itemId);
            if (currentQuantity - quantity < 0) {
                throw new RuntimeException("Not enough items in inventory");
            }
            inventory.put(itemId, currentQuantity - quantity);
        } else {
            throw new RuntimeException("Item not found in inventory");
        }
    }

    public void displayInventory() {
        System.out.println("Inventory:");
        for (Integer itemId : inventory.keySet()) {
            System.out.println("Item ID: " + itemId + ", Quantity: " + inventory.get(itemId));
        }
    }
}
