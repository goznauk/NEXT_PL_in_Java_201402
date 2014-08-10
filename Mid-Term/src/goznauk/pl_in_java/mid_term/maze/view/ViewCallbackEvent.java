package goznauk.pl_in_java.mid_term.maze.view;

/**
 * Created by goznauk on 2014. 8. 10..
 */
public interface ViewCallbackEvent {
    public abstract void onViewClosed();
    public void onResetButtonClicked();
    public void onExitButtonClicked();
}
