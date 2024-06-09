package vendingmachine;

import vendingmachine.enums.ItemType;

public class Item {
    private ItemType itemType;
    private int price;

    public Item() {
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
