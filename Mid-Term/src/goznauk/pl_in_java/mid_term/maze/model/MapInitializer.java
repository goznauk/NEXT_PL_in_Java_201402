package goznauk.pl_in_java.mid_term.maze.model;

import goznauk.pl_in_java.mid_term.maze.data.BLOCKTYPE;
import goznauk.pl_in_java.mid_term.maze.data.Block;
import goznauk.pl_in_java.mid_term.maze.data.Coordinate;

import java.io.*;

/**
 * Created by goznauk on 2014. 8. 3..
 */
public class MapInitializer {
    private Block[][] blocks;
    private int width, height, wallNum;
    private Coordinate goal;

    public MapInitializer(String path) {
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

            //br.reset();
            height = 0;

            br = new BufferedReader(new FileReader(csv));
            while ((line = br.readLine()) != null) {
                // -1 is for Read Blank after last ','
                String[] token = line.split(",", -1);
                for(int i = 0; i < token.length; i++) {
                    Block b = new Block(BLOCKTYPE.fromInteger(Integer.parseInt(token[i])), new Coordinate(i, height));
                    if(b.getType() == BLOCKTYPE.WALL) { wallNum++; }
                    blocks[height][i] = b;
                }
                height++;
            }
            br.close();

            blocks[0][0] = new Block(BLOCKTYPE.CURSOR, new Coordinate(0,0));
            goal = new Coordinate(width-1, height-1);
            blocks[height-1][width-1] = new Block(BLOCKTYPE.GOAL, goal);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Block[][] getBlocks() {
        return blocks;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getWallNum() {
        return wallNum;
    }

    public Coordinate getGoal() {
        return goal;
    }
}