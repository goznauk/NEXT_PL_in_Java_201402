package goznauk.pl_in_java.mid_term.model.blocks;

import goznauk.pl_in_java.mid_term.model.Coordinate;

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
