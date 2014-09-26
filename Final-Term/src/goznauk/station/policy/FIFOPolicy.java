package goznauk.station.policy;

import goznauk.Passenger;

/**
 * Created by goznauk on 2014. 9. 26..
 */
public class FIFOPolicy extends AbstractPolicy {
    @Override
    public int compare(Passenger p1, Passenger p2) {
        if(p1.getId() > p2.getId()) return 1;
        if(p1.getId() < p2.getId()) return -1;
        return 0;
    }
}
