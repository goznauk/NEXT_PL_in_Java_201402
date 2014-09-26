package goznauk.station;

import goznauk.Passenger;
import goznauk.station.policy.FIFOPolicy;
import goznauk.station.policy.SJFPolicy;

import java.util.PriorityQueue;

/**
 * Created by goznauk on 2014. 9. 26..
 */
public class TicketBox {
    //public PriorityQueue<Passenger> ticketingQueue = new PriorityQueue<Passenger>(60, new FIFOPolicy());
    public PriorityQueue<Passenger> ticketingQueue = new PriorityQueue<Passenger>(60, new SJFPolicy());

    private Clerk[] clerks = new Clerk[3];

    public boolean allNull() {
        return  clerks[0] == null && clerks[1] == null && clerks[2] == null;
    }

    public void renew(int now) {
        System.out.println("in ticketing Queue :");
        for(Passenger p : ticketingQueue) {
            System.out.print(p.getId() + ",");
        }
        System.out.println();


        for(int i = 0; i < 3; i++) {

            if(clerks[i] == null || clerks[i].isEnded(now)) {
                if(ticketingQueue.isEmpty()) {
                    System.out.println("clerk" + i + ": ticketingQueue Empty");
                    if(clerks != null || clerks[i].isEnded(now)) { clerks[i] = null; }
                    continue;
                }
                Passenger p = ticketingQueue.poll();
                clerks[i] = new Clerk(now, p.getId(), p.getTicketing());
                System.out.println("clerk" + i + ": ---started " + p.getId() + " - ends at " + (now + p.getTicketing()));
                continue;
            } else {
                System.out.println("clerk" + i + ": doing work " + clerks[i].getCustomerId() + " - ends at " + clerks[i].getEndtime());
            }
        }



    }


}
