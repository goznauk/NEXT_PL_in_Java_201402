package goznauk.pl_in_java.mid_term.maze.controller;

import goznauk.pl_in_java.mid_term.maze.model.IModel;
import goznauk.pl_in_java.mid_term.maze.model.Map;
import goznauk.pl_in_java.mid_term.maze.solution.BruteForceSolution;
import goznauk.pl_in_java.mid_term.maze.solution.FloodFillSolution;
import goznauk.pl_in_java.mid_term.maze.solution.ISolution;
import goznauk.pl_in_java.mid_term.maze.view.MapView;
import goznauk.pl_in_java.mid_term.maze.view.IView;
import goznauk.pl_in_java.mid_term.maze.view.ViewClosedEvent;

/**
 * Created by goznauk on 2014. 8. 3..
 */
public class Controller {
    protected IModel model;
    private IView view;
    private ISolution solution;

    public Controller() {
        this.model = new Map();


        init();
        execute();
    }

    ModelChangedCallbackEvent modelChangedCallbackEvent = new ModelChangedCallbackEvent() {
        @Override
        public void onModelChanged() {
            view.onModelUpdated(model);
        }
    };

    ViewClosedEvent viewClosedEvent = new ViewClosedEvent() {
        @Override
        public void onViewClosed() {
            solution.stop();
        }
    };


    public void init() {
        model.init();
        this.view = new MapView();

        view.init(model);
        model.setModelChangedCallbackEvent(modelChangedCallbackEvent);
        view.setViewClosedEvent(viewClosedEvent);
        setSolution(0x21);
    }


    /*
     * 01 : 4 Way
     * 10 : 8 Way
     *
     * 0001 : Manual
     * 0010 : Brute Force
     * 0100 : A Star
     * 1000 : Flood Fill
     */
    public void setSolution(int option) {
        // TODO set Solution

        boolean is4Way = true;

        if((option & 1) != 0) {
            is4Way = true;
        } else if ((option & 2) != 0) {
            is4Way = false;
        }

        option = option >> 4;

        if((option & 1) != 0) {
            //solution = new ManualSolution(model);
        } else if((option & 2) != 0) {
            solution = new BruteForceSolution(model, is4Way);
        } else if((option & 4) != 0) {
            //solution = new AStarSolution(model);
        } else if((option & 8) != 0) {
            //solution = new FloodFillSolution(model);
        }
    }

    public void execute() {
        solution.solve();
    }
}
