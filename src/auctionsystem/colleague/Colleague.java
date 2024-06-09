package auctionsystem.colleague;

public interface Colleague {
    void placeBid(int bidAmount);
    void receiveBigNotification(Colleague colleague, int bidAmount);
    String getName();
}
