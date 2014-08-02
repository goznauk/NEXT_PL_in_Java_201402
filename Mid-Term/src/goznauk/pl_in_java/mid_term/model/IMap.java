package goznauk.pl_in_java.mid_term.model;

/**
 * Created by goznauk on 2014. 8. 3..
 */
public interface IMap {

    public abstract int getMapWidth();

    public abstract int getMapHeight();

    public abstract Block getBlock(int x, int y);

}
