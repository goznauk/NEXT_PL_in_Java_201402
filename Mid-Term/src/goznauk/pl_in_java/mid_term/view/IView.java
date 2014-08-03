package goznauk.pl_in_java.mid_term.view;

import goznauk.pl_in_java.mid_term.model.IModel;

/**
 * Created by goznauk on 2014. 8. 3..
 */
public interface IView {
    public void init(IModel model);
    public void onModelUpdated(IModel model);
}
