package goznauk.pl_in_java.mid_term.maze;

import goznauk.pl_in_java.mid_term.maze.controller.Controller;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by goznauk on 2014. 8. 10..
 */
public class Maze {
    private List<Controller> mazeControllers;

    public Maze () {
        mazeControllers = new ArrayList<Controller>();
    }

    public void add(int option, String path) {
        mazeControllers.add(new Controller(mazeControllers.size(), option, path));
    }

    public void exitAll() {
        for(Controller c : mazeControllers) {
            c.exit();
        }
    }
}
