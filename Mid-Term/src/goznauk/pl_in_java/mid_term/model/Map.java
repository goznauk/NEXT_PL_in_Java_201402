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
    private Coordinate cursor, goal;
    private int wallNum;

    private ModelChangedCallbackEvent modelChangedCallbackEvent;



    public void setModelChangedCallbackEvent(ModelChangedCallbackEvent event) {
        if(!checkValidate()) {
            System.out.println("Error : Map is not validate");
            return;
        }
        modelChangedCallbackEvent = event;
    }

    @Override
    public boolean isSolved() {
        if(cursor.getX() == goal.getX() && cursor.getY() == goal.getY()) {
            return true;
        }
        return false;
    }

    public Map() {
        MapInitializer initializer = new MapInitializer("map.csv");
        blocks = initializer.getBlocks();
        width = initializer.getWidth();
        height = initializer.getHeight();
        wallNum = initializer.getWallNum();
        cursor = new Coordinate(0,0);
        goal = initializer.getGoal();
    }

    public Block getBlock(int x, int y) {
        return blocks[y][x];
    }

    private boolean isInMap(Coordinate c) {
        int x = c.getX();
        int y = c.getY();

        if(x<0 || x>=height) { return false; }
        if(y<0 || y>=height) { return false; }
        return true;
    }

    @Override
    public boolean canMoveCursor(DIRECTION d) {
        Coordinate destination = cursor.addDirection(d);
        if(!isInMap(destination)) { return false; }

        BLOCKTYPE type = blocks[destination.getY()][destination.getX()].getType();

        if(type.equals(BLOCKTYPE.PATH) || type.equals(BLOCKTYPE.GOAL)) {
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

    @Override
    public boolean tryMoveCursor(DIRECTION d) {
        if(canMoveCursor(d)) {
            moveCursor(d);
            return true;
        }
        System.out.println("Can't move");
        return false;
    }


    public int getMapWidth() { return width; }
    public int getMapHeight() { return height; }

    private boolean checkValidate() {
        int count = 0;
        int wallCount = 0;
        //TODO check the cursor is only one
        for(Block[] i : blocks) {
            for(Block b : i) {
                if(b.getType() == BLOCKTYPE.END) {
                  return true;
                } else if(b.getType() == BLOCKTYPE.CURSOR) {
                    count++;
                } else if(b.getType() == BLOCKTYPE.WALL) {
                    wallCount++;
                }
            }
        }

        if(count == 1 && wallCount == wallNum) { return true; }
        return false;
    }
}
