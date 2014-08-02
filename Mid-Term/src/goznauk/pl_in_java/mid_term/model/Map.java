package goznauk.pl_in_java.mid_term.model;

/**
 * Created by goznauk on 2014. 8. 3..
 */
public class Map implements IMap {
    private int width, height;
    private Block[][] blocks;

    public Map() {
        MapInitializer initializer = new MapInitializer("map.csv");
        blocks = initializer.getBlocks();
        width = initializer.getWidth();
        height = initializer.getHeight();
    }

    public Block getBlock(int x, int y) {
        return blocks[y][x];
    }

    public int getMapWidth() { return width; }
    public int getMapHeight() { return height; }
}
