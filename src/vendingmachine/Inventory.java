package vendingmachine;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    List<ItemShelf> itemShelfList;

    public Inventory(int itemsCounts) {
        this.itemShelfList = new ArrayList<>(itemsCounts);
        initializeInventory(itemsCounts);
    }

    private void initializeInventory(int itemsCounts) {
        int code = 101;
        for (int i = 0 ; i < itemsCounts; i++) {
            ItemShelf itemShelf = new ItemShelf(code, false);
            itemShelfList.add(itemShelf);
            code++;
        }
    }

    public void addItems(Item item, int code){
        for (ItemShelf itemShelf : itemShelfList) {
            if (itemShelf.getCode() == code) {
                itemShelf.setItem(item);
            }
        }
    }

    public Item getItem(int code) {
        for (ItemShelf itemShelf : itemShelfList) {
            if (itemShelf.getCode() == code) {
                if (itemShelf.isSoldOut()){
                    throw new RuntimeException("Item is sold out");
                }
                return itemShelf.getItem();
            }
        }
        throw new RuntimeException("Invalid Code");
    }

    public void updateSoldOutItem(int codeNumber){
        for (ItemShelf itemShelf : itemShelfList) {
            if (itemShelf.getCode() == codeNumber) {
                itemShelf.setSoldOut(true);
            }
        }
    }

    public List<ItemShelf> getItemShelfList() {
        return itemShelfList;
    }

    public void setItemShelfList(List<ItemShelf> itemShelfList) {
        this.itemShelfList = itemShelfList;
    }
}

