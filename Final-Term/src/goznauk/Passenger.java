package goznauk;

/**
 * Created by goznauk on 2014. 9. 26..
 */
public class Passenger {
    protected int id;
    private int arrived;
    private int ticketing;
    private int waiting;
    private int moving;
    private STATION i;
    private STATION f;

    public Passenger(int id, int arrived, int ticketing, STATION i, STATION f) {
        this.id = id;
        this.arrived = arrived;
        this.ticketing = ticketing;
        this.i = i;
        this.f = f;
    }

    public int getId() {
        return id;
    }

    public int getArrived() {
        return arrived;
    }

    public int getTicketing() {
        return ticketing;
    }

    public int getWaiting() {
        return waiting;
    }

    public void setWaiting(int waiting) {
        this.waiting = waiting;
    }

    public int getMoving() {
        return moving;
    }

    public void setMoving(int moving) {
        this.moving = moving;
    }

    public STATION getI() {
        return i;
    }

    public STATION getF() {
        return f;
    }
}
