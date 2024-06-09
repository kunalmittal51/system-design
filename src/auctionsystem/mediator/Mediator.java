package auctionsystem.mediator;

import auctionsystem.colleague.Colleague;

public interface Mediator {
    void addBidder(Colleague colleague);
    void placeBid(Colleague bidder, int bidAmount);
}
