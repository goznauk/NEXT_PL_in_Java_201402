package goznauk.pl_in_java.mid_term.model;

import goznauk.pl_in_java.mid_term.controller.ModelChangedCallbackEvent;
import goznauk.pl_in_java.mid_term.data.Block;
import goznauk.pl_in_java.mid_term.data.DIRECTION;

/**
 * Created by goznauk on 2014. 8. 5..
 */
public class Option implements IModel {
    public static int DIR_4 = 0x01;
    public static int DIR_8 = 0x02;
    public static int MODE_MANUAL = 0x10;
    public static int MODE_BRUTEFORCE = 0x20;
    public static int MODE_ASTAR = 0x30;
    public static int MODE_FLOODFILL = 0x40;


    @Override
    public void init() {

    }

    @Override
    public int getMapWidth() {
        return 0;
    }

    @Override
    public int getMapHeight() {
        return 0;
    }

    @Override
    public Block getBlock(int x, int y) {
        return null;
    }

    @Override
    public boolean canMoveCursor(DIRECTION d) {
        return false;
    }

    @Override
    public void moveCursor(DIRECTION d) {

    }

    @Override
    public boolean tryMoveCursor(DIRECTION d) {
        return false;
    }

    @Override
    public void setModelChangedCallbackEvent(ModelChangedCallbackEvent event) {

    }

    @Override
    public boolean isSolved() {
        return false;
    }
}
