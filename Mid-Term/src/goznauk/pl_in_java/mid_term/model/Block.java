package goznauk.pl_in_java.mid_term.model;

/**
 * Created by goznauk on 2014. 8. 3..
 */
public class Block {
    private BLOCKTYPE type;



    public Block(BLOCKTYPE type) {
        this.type = type;
    }

    public BLOCKTYPE getType() {
        return type;
    }
}
