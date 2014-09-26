package goznauk;

import goznauk.station.TicketBox;

public class Main {

    public static void main(String[] args) {

        Timer timer = new Timer();

        final TicketBox ticketBox = new TicketBox();

        final Loader loader = new Loader();



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
    }
}
