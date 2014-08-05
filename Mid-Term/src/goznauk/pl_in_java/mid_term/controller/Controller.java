package goznauk.pl_in_java.mid_term.controller;

import goznauk.pl_in_java.mid_term.data.DIRECTION;
import goznauk.pl_in_java.mid_term.model.IModel;
import goznauk.pl_in_java.mid_term.model.Map;
import goznauk.pl_in_java.mid_term.solution.BruteForceSolution;
import goznauk.pl_in_java.mid_term.solution.FloodFillSolution;
import goznauk.pl_in_java.mid_term.solution.ISolution;
import goznauk.pl_in_java.mid_term.view.GridView;
import goznauk.pl_in_java.mid_term.view.IView;
import goznauk.pl_in_java.mid_term.view.OptionView;

import java.awt.*;

/**
 * Created by goznauk on 2014. 8. 3..
 */
public class Controller {
    protected IModel model;
    private  IView view;
    private ISolution solution;

    public Controller() {
        this.model = new Map();


     //   OptionView optionView = new OptionView();
    //    optionView.initialize(this);
        init();
        execute();
    }

    ModelChangedCallbackEvent modelChangedCallbackEvent = new ModelChangedCallbackEvent() {
        @Override
        public void onModelChanged() {
            view.onModelUpdated(model);
        }
    };

    public void init() {
        model.init();
        this.view = new GridView();

        view.init(model);
        model.setModelChangedCallbackEvent(modelChangedCallbackEvent);

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
            solution = new FloodFillSolution(model);
        }
    }

    public void execute() {
        solution.solve();
    }
}
