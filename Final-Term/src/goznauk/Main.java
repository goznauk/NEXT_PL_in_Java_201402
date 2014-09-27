package goznauk;

import goznauk.file.Loader;
import goznauk.file.Saver;
import goznauk.map.PathFinder;
import goznauk.data.Passenger;
import goznauk.station.TicketBox;
import goznauk.station.TicketBoxCallback;
import goznauk.station.policy.SJFPolicy;
import goznauk.time.Timer;
import goznauk.time.TimerCallback;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        Timer timer = new Timer();
        final TicketBox ticketBox = new TicketBox(new SJFPolicy());
        final Loader loader = new Loader();
        final HashMap<Integer, Passenger> passengerMap = loader.load();
        final PathFinder pathFinder = new PathFinder();

        // FIXME : test code
        pathFinder.init();
        System.out.println("Graph:\n" + pathFinder.getGraph());


        ticketBox.setTicketBoxCallback(new TicketBoxCallback() {
            @Override
            public void onUpdated(int id, int endTime) {
                Passenger p = passengerMap.get(id);
                p.setWaitingTicket(endTime - p.getTicketing() - p.getArrived());
                if(endTime%3 == 0) p.setWaitingTrain(0);
                else p.setWaitingTrain(3-(endTime%3));
                pathFinder.init();
                System.out.println(" -> Passenger" + p.getId() + " is going to take a Train at " + (endTime + p.getWaitingTrain()) + "t");
                p.setMoving(pathFinder.findPath(p.getI(), p.getF()));
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

        // FIXME : test code
        for(int i = 1; passengerMap.get(i) != null; i++) {
            //System.out.println(passengerMap.get(i).toString());
        }
        Saver.SaveCsvFromHashMap(passengerMap);
    }
}
