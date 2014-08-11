package goznauk.pl_in_java.mid_term.entry.mapmaker;

/**
 * Created by goznauk on 2014. 8. 11..
 */
public interface MapMakerViewCallbackEvent {
    public void onMapChanged(int x, int y, boolean value);
    public void onSaveButtonClicked();
    public void onViewClosed();
}
