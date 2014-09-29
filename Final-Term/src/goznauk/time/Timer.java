package goznauk.time;

/**
 * Created by goznauk on 2014. 9. 26..
 */
public class Timer {
    private int time = 0;
    private TimerCallback timerCallbackEvent;

    public void tick() {
        System.out.println();
        System.out.println("--------------------------------------------------------------------------");
        System.out.println();
        System.out.println("tick : " + time);
        timerCallbackEvent.onTick(time);
        time++;
    }


    public void setTimerCallbackEvent(TimerCallback timerCallbackEvent) {
        this.timerCallbackEvent = timerCallbackEvent;
    }

    public void start() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 80; i++) {
                    try {
                        tick();
                        if(timerCallbackEvent.checkStop()) { return; }
                        Thread.sleep(1000);
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                        continue;
                    }
                }
            }
        });

        t.start();

    }
}
