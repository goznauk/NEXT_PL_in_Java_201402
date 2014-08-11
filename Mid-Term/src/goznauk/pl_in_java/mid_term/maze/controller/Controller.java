package goznauk.pl_in_java.mid_term.maze.controller;

import goznauk.pl_in_java.mid_term.maze.model.Map;
import goznauk.pl_in_java.mid_term.maze.model.ModelChangedCallbackEvent;
import goznauk.pl_in_java.mid_term.maze.solution.*;
import goznauk.pl_in_java.mid_term.maze.view.MapView;
import goznauk.pl_in_java.mid_term.maze.view.MapViewCallbackEvent;

import javax.swing.*;

/**
 * Created by goznauk on 2014. 8. 3..
 */
public class Controller {
    private Map model;
    private MapView view;
    private ISolution solution;
    private int id;

    private final String ERROR_LOAD = "Error Loading File\nPlease select a valid map file";

    public Controller(int id, int option, String path) {
        this.id = id;

        model = new Map(path);
        if(!model.isLoadedSuccess()) {
            JOptionPane.showMessageDialog(new JFrame(".."), ERROR_LOAD);
            exit();
        }
        view = new MapView("[" + id + "] Option : 0x" + Integer.toHexString(option));

        view.init(model);
        model.setModelChangedCallbackEvent(modelChangedCallbackEvent);
        view.setMapViewCallbackEvent(mapViewCallbackEvent);

        setSolution(option);
        execute();
    }

    MapViewCallbackEvent mapViewCallbackEvent = new MapViewCallbackEvent() {
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

        boolean is4Way = true;

        if((option & 1) != 0) {
            is4Way = true;
        } else if ((option & 2) != 0) {
            is4Way = false;
        }

        option = option >> 4;

        switch (option) {
            case 1:
                solution = new ManualSolution(model, view, is4Way);
                break;
            case 2:
                solution = new BruteForceSolution(model, is4Way);
                break;
            case 3:
                solution = new AStarSolution(model, is4Way);
                break;
            case 4:
                solution = new FloodFillSolution(model, view, is4Way);
                break;
        }
    }

    public void execute() {
        solution.init();
        solution.solve();
    }
}
