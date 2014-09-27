package goznauk.station.policy;

import goznauk.data.Passenger;

/**
 * Created by goznauk on 2014. 9. 26..
 */
public class SJFPolicy extends AbstractPolicy{
    @Override
    public int compare(Passenger p1, Passenger p2) {
        if(p1.getTicketing() > p2.getTicketing()) return 1;
        if(p1.getTicketing() < p2.getTicketing()) return -1;
        return 0;
    }
}
