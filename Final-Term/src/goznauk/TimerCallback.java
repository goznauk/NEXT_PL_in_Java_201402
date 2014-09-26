package goznauk;

/**
 * Created by goznauk on 2014. 9. 26..
 */
public interface TimerCallback {
    public boolean checkStop();

    public void onTick(int time);
}
