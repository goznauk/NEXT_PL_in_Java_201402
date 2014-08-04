package goznauk.pl_in_java.mid_term.data;

/**
 * Created by goznauk on 2014. 8. 3..
 */
public enum BLOCKTYPE {
    PATH, WALL, CURSOR, GOAL, END;

    public static BLOCKTYPE fromInteger(int x) {
        switch(x) {
            case 0:
                return PATH;
            case 1:
                return WALL;
            case 2:
                return CURSOR;
            case 3:
                return GOAL;
            case 4:
                return END;
        }
        return null;
    }
}
