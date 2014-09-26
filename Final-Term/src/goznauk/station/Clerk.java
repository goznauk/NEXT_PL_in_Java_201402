package goznauk.station;

/**
 * Created by goznauk on 2014. 9. 26..
 */
public class Clerk {
    private int initializedTime, customerId, ticketingTime;

    public Clerk(int initializedTime, int customerId, int ticketingTime) {
        this.initializedTime = initializedTime;
        this.customerId = customerId;
        this.ticketingTime = ticketingTime;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getEndtime() {
        return initializedTime + ticketingTime;
    }

    public boolean isEnded(int now) {
        return (initializedTime + ticketingTime) == now;
    }
}
