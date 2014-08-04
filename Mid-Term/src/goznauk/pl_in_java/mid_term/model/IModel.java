package goznauk.pl_in_java.mid_term.model;

import goznauk.pl_in_java.mid_term.controller.ModelChangedCallbackEvent;
import goznauk.pl_in_java.mid_term.model.blocks.Block;

/**
 * Created by goznauk on 2014. 8. 3..
 */
public interface IModel {

    public abstract int getMapWidth();

    public abstract int getMapHeight();

    public abstract Block getBlock(int x, int y);

    public abstract boolean canMoveCursor(DIRECTION d);

    public abstract void moveCursor(DIRECTION d);

    public abstract boolean tryMoveCursor(DIRECTION d);

    public void setModelChangedCallbackEvent(ModelChangedCallbackEvent event);

    public abstract boolean isSolved();

}
