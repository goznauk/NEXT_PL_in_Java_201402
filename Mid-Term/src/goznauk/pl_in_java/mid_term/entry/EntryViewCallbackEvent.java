package goznauk.pl_in_java.mid_term.entry;

/**
 * Created by goznauk on 2014. 8. 10..
 */
public interface EntryViewCallbackEvent {
    public void onOptionChanged();
    public void onMapPathChanged();
    public void onMapMakeButtonClicked();
    public void onStartButtonClicked();
    public void onExitButtonClicked();
}
