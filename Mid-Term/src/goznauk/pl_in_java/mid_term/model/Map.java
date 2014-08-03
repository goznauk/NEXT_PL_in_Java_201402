package goznauk.pl_in_java.mid_term.model;

import goznauk.pl_in_java.mid_term.controller.ModelChangedCallbackEvent;
import goznauk.pl_in_java.mid_term.model.blocks.BLOCKTYPE;
import goznauk.pl_in_java.mid_term.model.blocks.Block;

import java.util.Observable;

/**
 * Created by goznauk on 2014. 8. 3..
 */
public class Map implements IModel {
    private int width, height;
    private Block[][] blocks;
    private Coordinate cursor;

    private ModelChangedCallbackEvent modelChangedCallbackEvent;



    public void setModelChangedCallbackEvent(ModelChangedCallbackEvent event) {
        modelChangedCallbackEvent = event;
    }

    public Map() {
        MapInitializer initializer = new MapInitializer("map.csv");
        blocks = initializer.getBlocks();
        width = initializer.getWidth();
        height = initializer.getHeight();

        cursor = new Coordinate(0,0);
    }

    public Block getBlock(int x, int y) {
        return blocks[y][x];
    }

    @Override
    public boolean canMoveCursor(DIRECTION d) {
        Coordinate destination = cursor.addDirection(d);
        if(blocks[destination.getY()][destination.getX()].getType().equals(BLOCKTYPE.PATH)) {
            return true;
        }
        return false;
    }

    @Override
    public void moveCursor(DIRECTION d) {
        blocks[cursor.getY()][cursor.getX()].setType(BLOCKTYPE.PATH);
        cursor.moveDirection(d);
        blocks[cursor.getY()][cursor.getX()].setType(BLOCKTYPE.CURSOR);

        System.out.println("now the cursor is on " + cursor.getX() + "," + cursor.getY() + blocks[cursor.getY()][cursor.getX()].getType());

        modelChangedCallbackEvent.onModelChanged();

    }



    public int getMapWidth() { return width; }
    public int getMapHeight() { return height; }

    private boolean checkValidate() {
        //TODO check the cursor is only one
        return true;
    }
}
