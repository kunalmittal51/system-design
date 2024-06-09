package vendingmachine;

import vendingmachine.enums.Coin;
import vendingmachine.enums.ItemType;
import vendingmachine.states.State;

import java.util.List;

public class DriverClass {
    public static void main(String args[]){

        VendingMachine vendingMachine = new VendingMachine();
        try {

            System.out.println("|");
            System.out.println("filling up the inventory");
            System.out.println("|");

            fillUpInventory(vendingMachine);
            displayInventory(vendingMachine);

            System.out.println("|");
            System.out.println("clicking on InsertCoinButton");
            System.out.println("|");

            State vendingState = vendingMachine.getState();
            vendingState.clickOnInsertCoinButton(vendingMachine);

            vendingState = vendingMachine.getState();
            vendingState.insertCoin(vendingMachine, Coin.NICKEL);
            vendingState.insertCoin(vendingMachine, Coin.QUARTER);
            // vendingState.insertCoin(vendingMachine, Coin.NICKEL);

            System.out.println("|");
            System.out.println("clicking on ProductSelectionButton");
            System.out.println("|");
            vendingState.clickOnStartProductSelectionButton(vendingMachine);

            vendingState = vendingMachine.getState();
            vendingState.chooseProduct(vendingMachine, 102);

            displayInventory(vendingMachine);

        }
        catch (Exception e){
            displayInventory(vendingMachine);
        }
    }

    private static void fillUpInventory(VendingMachine vendingMachine){
        List<ItemShelf> slots = vendingMachine.getInventory().getItemShelfList();
        for (int i = 0; i < slots.size(); i++) {
            Item newItem = new Item();
            if(i<3) {
                newItem.setItemType(ItemType.COKE);
                newItem.setPrice(12);
            }else if(i<5){
                newItem.setItemType(ItemType.PEPSI);
                newItem.setPrice(9);
            }else if(i<7){
                newItem.setItemType(ItemType.SPRITE);
                newItem.setPrice(13);
            }else if(i<10){
                newItem.setItemType(ItemType.SODA);
                newItem.setPrice(7);
            }
            slots.get(i).setItem(newItem);
            slots.get(i).setSoldOut(false);
        }
    }

    private static void displayInventory(VendingMachine vendingMachine){

        List<ItemShelf> slots = vendingMachine.getInventory().getItemShelfList();
        for (int i = 0; i < slots.size(); i++) {

            System.out.println("CodeNumber: " + slots.get(i).getCode() +
                    " Item: " + slots.get(i).getItem().getItemType().name() +
                    " Price: " + slots.get(i).getItem().getPrice() +
                    " isAvailable: " + !slots.get(i).isSoldOut());
        }
    }

}
