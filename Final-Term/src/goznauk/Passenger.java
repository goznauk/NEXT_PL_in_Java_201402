package goznauk;

/**
 * Created by goznauk on 2014. 9. 26..
 */
public class Passenger {
    protected int id;
    private int arrived;
    private int ticketing;
    private int waitingTicket;
    private int waitingTrain;
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

    public int getWaitingTicket() {
        return waitingTicket;
    }

    public void setWaitingTicket(int waitingTicket) {
        this.waitingTicket = waitingTicket;
    }

    public int getWaitingTrain() {
        return waitingTrain;
    }

    public void setWaitingTrain(int waitingTrain) {
        this.waitingTrain = waitingTrain;
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

    public String toString() {
        return "[ID:" + id + "] arrived : " + arrived + " | ticketing : " + ticketing + " | waiting_Tk : " + waitingTicket + " | waiting_Tr : " + waitingTrain + " | moving : " + moving;
    }

}
