package goznauk.pl_in_java.mid_term.maze.view;

import goznauk.pl_in_java.mid_term.maze.model.IModel;

/**
 * Created by goznauk on 2014. 8. 3..
 */
public interface IView {
    public void init(IModel model);
    public void onModelUpdated(IModel model);
    public void setViewClosedEvent(ViewClosedEvent event);
}
