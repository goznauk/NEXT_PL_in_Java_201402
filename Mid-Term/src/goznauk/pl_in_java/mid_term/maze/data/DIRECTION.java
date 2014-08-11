package goznauk.pl_in_java.mid_term.maze.data;

/**
 * Created by goznauk on 2014. 8. 3..
 */
public enum DIRECTION {
    U(1), D(2), L(4), R(8), UL(16), UR(32), DL(64), DR(128);

    private final int value;
    private DIRECTION(int value) {
        this.value = value;
    }

    public void setValue() {

    }
    public int getValue() {
        return value;
    }
}
