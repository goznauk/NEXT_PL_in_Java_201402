package goznauk.station.policy;

import goznauk.Passenger;

import java.util.Comparator;

/**
 * Created by goznauk on 2014. 9. 26..
 */
public abstract class AbstractPolicy implements Comparator<Passenger> {
    @Override
    public abstract int compare(Passenger p1, Passenger p2);
}
