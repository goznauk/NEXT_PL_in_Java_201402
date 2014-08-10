package goznauk.pl_in_java.mid_term.maze.controller;

import goznauk.pl_in_java.mid_term.maze.data.DIRECTION;
import goznauk.pl_in_java.mid_term.maze.model.Map;
import goznauk.pl_in_java.mid_term.maze.solution.BruteForceSolution;
import goznauk.pl_in_java.mid_term.maze.solution.ISolution;
import goznauk.pl_in_java.mid_term.maze.solution.ManualSolution;
import goznauk.pl_in_java.mid_term.maze.view.MapView;
import goznauk.pl_in_java.mid_term.maze.view.ViewCallbackEvent;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by goznauk on 2014. 8. 3..
 */
public class Controller {
    private Map model;
    private MapView view;
    private ISolution solution;
    private int id;

    public Controller(int id, int option, String path) {
        this.id = id;

        model = new Map(path);
        view = new MapView("[" + id + "] Option : 0x" + Integer.toHexString(option));

        view.init(model);
        model.setModelChangedCallbackEvent(modelChangedCallbackEvent);
        view.setViewCallbackEvent(viewCallbackEvent);

        setSolution(option);
        execute();
    }

    ViewCallbackEvent viewCallbackEvent = new ViewCallbackEvent() {
        @Override
        public void onViewClosed() {
            System.out.println("onViewClosed()");
            solution.stop();
        }

        @Override
        public void onResetButtonClicked() {
            solution.stop();
            model.init();
            view.init(model);

            execute();
        }

        @Override
        public void onExitButtonClicked() {
            System.out.println("onViewClosed()");
            exit();
        }
    };

    public void exit() {
        solution.stop();
        view.exit();
    }

    ModelChangedCallbackEvent modelChangedCallbackEvent = new ModelChangedCallbackEvent() {
        @Override
        public void onModelChanged() {
            view.onModelUpdated(model);
        }
    };


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
            solution = new ManualSolution(model, view, is4Way);
        } else if((option & 2) != 0) {
            solution = new BruteForceSolution(model, is4Way);
        } else if((option & 4) != 0) {
            //solution = new AStarSolution(model);
        } else if((option & 8) != 0) {
            //solution = new FloodFillSolution(model);
        }
    }

    public void execute() {
        solution.init();
        solution.solve();
    }

    public void stop() { solution.stop(); }
}
