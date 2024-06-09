package auctionsystem.colleague;

import auctionsystem.mediator.Mediator;

public class Bidder implements Colleague {
    String name;
    Mediator mediator;

    public Bidder(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    @Override
    public void placeBid(int bidAmount) {
        mediator.placeBid(this, bidAmount);
    }

    @Override
    public void receiveBigNotification(Colleague colleague, int bidAmount) {
        System.out.println("Received notification by: " + getName() +
                " from colleague: " + colleague.getName() + " with bid amount: " + bidAmount);
    }

    @Override
    public String getName() {
        return name;
    }
}
