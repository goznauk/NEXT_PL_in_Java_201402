package goznauk.pl_in_java.mid_term.model;

/**
 * Created by goznauk on 2014. 8. 3..
 */
public class Coordinate {
    private int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Coordinate getAnonymusCoordinate(int x, int y, int xx, int yy) {
        Coordinate tmp = new Coordinate(x + xx, y + yy);
        return tmp;
    }

    public Coordinate addDirection(DIRECTION dir) {
        switch (dir) {
            case U:
                return getAnonymusCoordinate(this.x, this.y, 0, -1);
            case D:
                return getAnonymusCoordinate(this.x, this.y, 0, 1);
            case L:
                return getAnonymusCoordinate(this.x, this.y, -1, 0);
            case R:
                return getAnonymusCoordinate(this.x, this.y, 1, 0);
            case UL:
                return addDirection(DIRECTION.U).addDirection(DIRECTION.L);
            case UR:
                return addDirection(DIRECTION.U).addDirection(DIRECTION.R);
            case DL:
                return addDirection(DIRECTION.D).addDirection(DIRECTION.L);
            case DR:
                return addDirection(DIRECTION.D).addDirection(DIRECTION.R);
            default:
                return null;
        }
    }

    public void moveDirection(DIRECTION dir) {
        this.x = this.addDirection(dir).x;
        this.y = this.addDirection(dir).y;
    }
}
