package auctionsystem;

import auctionsystem.colleague.Bidder;
import auctionsystem.mediator.AuctionMediator;

public class DriverClass {
    public static void main(String[] args) {
        AuctionMediator mediator = new AuctionMediator();
        Bidder bidder1 = new Bidder("Bidder 1", mediator);
        Bidder bidder2 = new Bidder("Bidder 2", mediator);
        Bidder bidder3 = new Bidder("Bidder 3", mediator);

        mediator.addBidder(bidder1);
        mediator.addBidder(bidder2);
        mediator.addBidder(bidder3);

        bidder1.placeBid(100);
        bidder2.placeBid(200);
        bidder3.placeBid(300);
    }
}
