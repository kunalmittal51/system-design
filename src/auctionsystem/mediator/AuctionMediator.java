package auctionsystem.mediator;

import auctionsystem.colleague.Colleague;

import java.util.ArrayList;
import java.util.List;

public class AuctionMediator implements Mediator {
    List<Colleague> colleagueList = new ArrayList<>();

    @Override
    public void addBidder(Colleague colleague) {
        colleagueList.add(colleague);
    }

    @Override
    public void placeBid(Colleague bidder, int bidAmount) {
        for (Colleague colleague : colleagueList) {
            if (colleague != bidder) {
                colleague.receiveBigNotification(bidder, bidAmount);
            }
        }
    }
}
