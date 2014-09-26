package goznauk;

import goznauk.Train.PathFinder;
import goznauk.station.TicketBox;
import goznauk.station.TicketBoxCallback;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        Timer timer = new Timer();
        final TicketBox ticketBox = new TicketBox();
        final Loader loader = new Loader();
        final HashMap<Integer, Passenger> passengerMap = loader.load();
        final PathFinder pathFinder = new PathFinder();

        ticketBox.setTicketBoxCallback(new TicketBoxCallback() {
            @Override
            public void onUpdated(int id, int endTime) {
                Passenger p = passengerMap.get(id);
                p.setWaitingTicket(endTime - p.getTicketing() - p.getArrived());
                if(endTime%3 == 0) p.setWaitingTrain(0);
                else p.setWaitingTrain(3-(endTime%3));
                p.setMoving(pathFinder.getElapsedTime(p.getI(), p.getF()));
            }
        });


        timer.setTimerCallbackEvent(new TimerCallback() {
            @Override
            public boolean checkStop() {
                return ticketBox.ticketingQueue.isEmpty() && loader.inputQueue.isEmpty() && ticketBox.allNull();
            }

            @Override
            public void onTick(int time) {
                while (!loader.inputQueue.isEmpty() && loader.inputQueue.peek().getArrived() <= time) {
                    ticketBox.ticketingQueue.add(loader.inputQueue.poll());
                }
                ticketBox.renew(time);
            }
        });

        timer.start();


        for(Passenger p : passengerMap.values()) {
            System.out.println(p.toString());
        }
    }
}
