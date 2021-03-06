package goznauk.pl_in_java.mid_term.maze.model;

import goznauk.pl_in_java.mid_term.maze.data.BLOCKTYPE;
import goznauk.pl_in_java.mid_term.maze.data.Block;
import goznauk.pl_in_java.mid_term.maze.data.Coordinate;
import goznauk.pl_in_java.mid_term.maze.data.DIRECTION;

import java.io.*;

/**
 * Created by goznauk on 2014. 8. 3..
 */
public class Map {
    private int width, height;
    private Block[][] blocks;
    private Coordinate cursor, goal;
    private int wallNum;
    private int moved;
    private boolean loadedSuccess = true;
    private String path;
    private boolean isLoading = false;

    public Map(String path) {
        this.path = path;
        init();
    }

    private ModelChangedCallbackEvent modelChangedCallbackEvent;
    public void setModelChangedCallbackEvent(ModelChangedCallbackEvent event) {
       /*
        if(!checkValidate()) {
            System.out.println("Error : Map is not validate");
            return;
        }*/
        modelChangedCallbackEvent = event;
    }

    public void init() {
        if(isLoading) { return; }
        isLoading = true;


        if(path.equals("Please Select the Map Path")) {
            width = 10;
            height = 8;

            String[] lines =
                    {"0,1,1,1,0,1,1,1,1,0",
                            "0,0,0,1,0,0,0,0,0,0",
                            "1,1,0,0,0,1,0,1,1,1",
                            "1,1,0,1,0,1,0,1,0,1",
                            "1,0,0,1,0,0,0,0,0,0",
                            "0,1,1,1,0,1,1,1,1,0",
                            "1,0,1,1,0,0,0,0,1,1",
                            "0,1,1,0,1,1,1,0,0,0"};
            for(int i = 0; i < lines.length; i++) {
                // -1 is for Read Blank after last ','
                String[] token = lines[i].split(",", -1);

                //TODO test and plus or minus 1
                width = token.length;
                height++;
            }

            blocks = new Block[height][width];

            height = 0;

            try {
                for(int i = 0; i < lines.length; i++) {
                    // -1 is for Read Blank after last ','
                    String[] token = lines[i].split(",", -1);
                    for (int j = 0; j < token.length; j++) {
                        Block b = new Block(BLOCKTYPE.fromInteger(Integer.parseInt(token[j])), new Coordinate(j, height));
                        if (b.getType() == BLOCKTYPE.WALL) {
                            wallNum++;
                        }
                        blocks[height][j] = b;
                    }
                    height++;
                }

                cursor = new Coordinate(0,0);
                blocks[0][0] = new Block(BLOCKTYPE.CURSOR, cursor);
                goal = new Coordinate(width-1, height-1);
                blocks[height-1][width-1] = new Block(BLOCKTYPE.GOAL, goal);

                moved = 0;
            } catch (Exception e) {
                loadedSuccess = false;
                e.printStackTrace();
                System.out.println("loaded success " + loadedSuccess);
            }
        } else {
            try {
                File csv = new File(path);
                BufferedReader br = new BufferedReader(new FileReader(csv));
                String line = "";

                width = 0;
                height = 0;

                while ((line = br.readLine()) != null) {
                    // -1 is for Read Blank after last ','
                    String[] token = line.split(",", -1);

                    //TODO test and plus or minus 1
                    width = token.length;
                    height++;
                }
                blocks = new Block[height][width];

                height = 0;

                try {
                    br = new BufferedReader(new FileReader(csv));
                    while ((line = br.readLine()) != null) {
                        // -1 is for Read Blank after last ','
                        String[] token = line.split(",", -1);
                        for (int i = 0; i < token.length; i++) {
                            Block b = new Block(BLOCKTYPE.fromInteger(Integer.parseInt(token[i])), new Coordinate(i, height));
                            if (b.getType() == BLOCKTYPE.WALL) {
                                wallNum++;
                            }
                            blocks[height][i] = b;
                        }
                        height++;
                    }
                    br.close();

                    cursor = new Coordinate(0, 0);
                    blocks[0][0] = new Block(BLOCKTYPE.CURSOR, cursor);
                    goal = new Coordinate(width - 1, height - 1);
                    blocks[height - 1][width - 1] = new Block(BLOCKTYPE.GOAL, goal);

                    moved = 0;
                } catch (Exception e) {
                    loadedSuccess = false;
                    e.printStackTrace();
                    System.out.println("loaded success " + loadedSuccess);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        isLoading = false;
    }

    public boolean tryInit() {
        init();
        return !isLoading;
    }

    public boolean isSolved() {
        if(cursor.getX() == goal.getX() && cursor.getY() == goal.getY()) {
            return true;
        }
        return false;
    }

    public boolean isSolved(Coordinate pos) {
        if(pos.getX() == goal.getX() && pos.getY() == goal.getY()) {
            return true;
        }
        return false;
    }


    public boolean canMoveCursor(DIRECTION d) {
        Coordinate destination = cursor.addDirection(d);
        if(!isInMap(destination)) { return false; }

        BLOCKTYPE type = blocks[destination.getY()][destination.getX()].getType();

        if(type.equals(BLOCKTYPE.PATH) || type.equals(BLOCKTYPE.GOAL)) {
            return true;
        }
        return false;
    }

    public boolean canMoveCursor(Coordinate cursor, DIRECTION d) {
        Coordinate destination = cursor.addDirection(d);
        if(!isInMap(destination)) { return false; }

        BLOCKTYPE type = blocks[destination.getY()][destination.getX()].getType();

        if(type.equals(BLOCKTYPE.PATH) || type.equals(BLOCKTYPE.GOAL)) {
            return true;
        }
        return false;
    }

    public void moveCursor(DIRECTION d) {
        blocks[cursor.getY()][cursor.getX()].setType(BLOCKTYPE.PATH);
        cursor.moveDirection(d);
        blocks[cursor.getY()][cursor.getX()].setType(BLOCKTYPE.CURSOR);

        System.out.println("now the cursor is on " + cursor.getX() + "," + cursor.getY() + blocks[cursor.getY()][cursor.getX()].getType());
        moved++;

        modelChangedCallbackEvent.onModelChanged();
    }

    public void moveCursor(Coordinate cursor, DIRECTION d) {
        //blocks[cursor.getY()][cursor.getX()].setType(BLOCKTYPE.PATH);
        cursor.moveDirection(d);
        blocks[cursor.getY()][cursor.getX()].setType(BLOCKTYPE.CURSOR);

       // System.out.println("now the cursor is on " + cursor.getX() + "," + cursor.getY() + blocks[cursor.getY()][cursor.getX()].getType());
        moved++;

        modelChangedCallbackEvent.onModelChanged();
    }

    public boolean tryMoveCursor(DIRECTION d) {
        if(canMoveCursor(d)) {
            moveCursor(d);
            return true;
        }
        System.out.println("Can't move");
        return false;
    }

    public boolean tryMoveCursor(Coordinate cursor, DIRECTION d) {
        if(canMoveCursor(cursor,d)) {
            moveCursor(cursor, d);
            return true;
        }
        System.out.println("Can't move");
        return false;
    }

    public void setCursor(Coordinate c) {
        if(!getBlock(c.getX(), c.getY()).getType().equals(BLOCKTYPE.CURSOR)) {
            blocks[c.getY()][c.getX()].setType(BLOCKTYPE.CURSOR);
            moved++;
            modelChangedCallbackEvent.onModelChanged();
        }
    }

    public void setPath(Coordinate c) {
        if(!getBlock(c.getX(), c.getY()).getType().equals(BLOCKTYPE.PATH)) {
            blocks[c.getY()][c.getX()].setType(BLOCKTYPE.PATH);
            modelChangedCallbackEvent.onModelChanged();
        }
    }

    public boolean isLoadedSuccess() {
        return loadedSuccess;
    }
    public Block getBlock(int x, int y) {
        return blocks[y][x];
    }
    public int getMapWidth() { return width; }
    public int getMapHeight() { return height; }

    private boolean isInMap(Coordinate c) {
        int x = c.getX();
        int y = c.getY();

        if(x<0 || x>=width) { return false; }
        if(y<0 || y>=height) { return false; }
        return true;
    }

    private boolean checkValidate() {
        int count = 0;
        int wallCount = 0;

        //TODO check the cursor is only one & wall number is not changed
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

    public int getMoved() {
        return moved;
    }
}
