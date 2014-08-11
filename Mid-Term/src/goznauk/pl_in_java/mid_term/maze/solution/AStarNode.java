package goznauk.pl_in_java.mid_term.maze.solution;

import goznauk.pl_in_java.mid_term.maze.data.Coordinate;

/**
 * Created by goznauk on 2014. 8. 11..
 */
public class AStarNode {
    int f;            // f = g+h
    int h;            // heuristic
    int g;            // distance
    Coordinate pos;
    AStarNode prev;
    AStarNode adjacent[];
    AStarNode next;

    public AStarNode(boolean is4Way) {
        if (is4Way) {
            adjacent = new AStarNode[4];
            for (int i = 0; i < 4; i++) {
                adjacent[i] = null;
            }
        } else {
            adjacent = new AStarNode[8];
            for (int i = 0; i < 8; i++) {
                adjacent[i] = null;
            }
        }
    }
}
