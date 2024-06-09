package vendingmachine;

import vendingmachine.enums.Coin;
import vendingmachine.states.State;
import vendingmachine.states.stateimpl.IdleState;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private State state;
    private Inventory inventory;
    private List<Coin> coinList;

    public VendingMachine(){
        state = new IdleState();
        inventory = new Inventory(10);
        coinList = new ArrayList<>();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public List<Coin> getCoinList() {
        return coinList;
    }

    public void setCoinList(List<Coin> coinList) {
        this.coinList = coinList;
    }
}
