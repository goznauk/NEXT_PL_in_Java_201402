package goznauk.pl_in_java.mid_term.data;

/**
 * Created by goznauk on 2014. 8. 3..
 */
public class Block {
    private BLOCKTYPE type;
    protected Coordinate pos;


    public Block(BLOCKTYPE type, Coordinate pos) {
        this.type = type;
        this.pos = pos;
    }

    public BLOCKTYPE getType() {
        return type;
    }
    public void setType(BLOCKTYPE type) { this.type = type;}
}
