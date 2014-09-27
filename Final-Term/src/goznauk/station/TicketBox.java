package goznauk.station;

import goznauk.data.Passenger;
import goznauk.station.policy.AbstractPolicy;
import goznauk.station.policy.FIFOPolicy;
import goznauk.station.policy.SJFPolicy;

import java.util.PriorityQueue;

/**
 * Created by goznauk on 2014. 9. 26..
 */
public class TicketBox<P extends AbstractPolicy> {
    public PriorityQueue<Passenger> ticketingQueue;

    private Clerk[] clerks = new Clerk[3];
    private TicketBoxCallback ticketBoxCallback;

    public TicketBox(P policy) {
        ticketingQueue = new PriorityQueue<Passenger>(60, policy);
    }

    public boolean allNull() {
        return  clerks[0] == null && clerks[1] == null && clerks[2] == null;
    }

    public void renew(int now) {
        // FIXME : test code
        System.out.print("in ticketing Queue : ");
        for(Passenger p : ticketingQueue) {
            System.out.print(p.getId() + ",");
        }
        System.out.println();
        System.out.println();

        for(int i = 0; i < 3; i++) {
            if(clerks[i] == null || clerks[i].isEnded(now)) {
                if(ticketingQueue.isEmpty()) {
                    // FIXME : test code
                    System.out.println("clerk" + i + ": Playing Cards (ticketingQueue Empty)");

                    if(clerks[i] != null && clerks[i].isEnded(now)) {
                        System.out.println("clerk" + i + ": ---ended [" + clerks[i].getCustomerId() + "]");
                        ticketBoxCallback.onUpdated(clerks[i].getCustomerId(), clerks[i].getEndtime());
                        clerks[i] = null;
                    }
                    continue;
                }

                Passenger p = ticketingQueue.poll();
                if(clerks[i] != null) {
                    System.out.println("clerk" + i + ": -- ended [" + clerks[i].getCustomerId() + "]");
                    ticketBoxCallback.onUpdated(clerks[i].getCustomerId(), clerks[i].getEndtime());
                }
                clerks[i] = new Clerk(now, p.getId(), p.getTicketing());
                // FIXME : test code
                System.out.println("clerk" + i + ": -- started [" + p.getId() + "] - ends at " + (now + p.getTicketing()) + "t");
            } else {
                // FIXME : test code
                System.out.println("clerk" + i + ": doing work [" + clerks[i].getCustomerId() + "] - ends at " + clerks[i].getEndtime() + "t");
            }
        }
        System.out.println();
    }

    public void setTicketBoxCallback(TicketBoxCallback ticketBoxCallback) {
        this.ticketBoxCallback = ticketBoxCallback;
    }
}
