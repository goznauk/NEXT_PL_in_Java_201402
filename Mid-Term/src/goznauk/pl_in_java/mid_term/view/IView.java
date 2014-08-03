package goznauk.pl_in_java.mid_term.view;

import goznauk.pl_in_java.mid_term.model.IMap;

/**
 * Created by goznauk on 2014. 8. 3..
 */
public interface IView {
    public void init(IMap model);
    public void onModelUpdated(IMap model);
}
