package goznauk.pl_in_java.mid_term.controller;

import goznauk.pl_in_java.mid_term.model.DIRECTION;
import goznauk.pl_in_java.mid_term.model.IModel;
import goznauk.pl_in_java.mid_term.solution.BruteForceSolution;
import goznauk.pl_in_java.mid_term.solution.ISolution;
import goznauk.pl_in_java.mid_term.view.IView;

/**
 * Created by goznauk on 2014. 8. 3..
 */
public class ManualController implements IController {
    protected final IModel map;
    private final IView view;
    private ISolution solution;

    public ManualController(IModel map, final IView view) {
        this.map = map;
        this.view = view;

        view.init(map);
        map.setModelChangedCallbackEvent(modelChangedCallbackEvent);


        solution = new BruteForceSolution(map);
        solution.solve();


       // moveExample();
    }


    ModelChangedCallbackEvent modelChangedCallbackEvent = new ModelChangedCallbackEvent() {
        @Override
        public void onModelChanged() {
            view.onModelUpdated(map);
        }
    };


    public void moveExample() {
        try { Thread.sleep(1000l); } catch(Exception e) { }

        map.moveCursor(DIRECTION.D);

        try {
            Thread.sleep(1000l);
        } catch (Exception e) {
        }

        map.moveCursor(DIRECTION.R);

        try {
            Thread.sleep(1000l);
        } catch (Exception e) {
        }

        map.moveCursor(DIRECTION.R);

        try {
            Thread.sleep(1000l);
        } catch (Exception e) {
        }

        map.moveCursor(DIRECTION.D);

        try {
            Thread.sleep(1000l);
        } catch (Exception e) {
        }

        map.moveCursor(DIRECTION.R);

        try {
            Thread.sleep(1000l);
        } catch (Exception e) {
        }

        map.moveCursor(DIRECTION.R);

        try {
            Thread.sleep(1000l);
        } catch (Exception e) {
        }

        map.moveCursor(DIRECTION.U);

        try {
            Thread.sleep(1000l);
        } catch (Exception e) {
        }

        map.moveCursor(DIRECTION.R);

        try {
            Thread.sleep(1000l);
        } catch (Exception e) {
        }

        map.moveCursor(DIRECTION.R);

        try {
            Thread.sleep(1000l);
        } catch (Exception e) {
        }

        map.moveCursor(DIRECTION.D);

        try {
            Thread.sleep(1000l);
        } catch (Exception e) {
        }

        map.moveCursor(DIRECTION.D);

        try {
            Thread.sleep(1000l);
        } catch (Exception e) {
        }

        map.moveCursor(DIRECTION.D);

        try {
            Thread.sleep(1000l);
        } catch (Exception e) {
        }

        map.moveCursor(DIRECTION.L);

        try {
            Thread.sleep(1000l);
        } catch (Exception e) {
        }

        map.moveCursor(DIRECTION.L);

        try {
            Thread.sleep(1000l);
        } catch (Exception e) {
        }

        map.moveCursor(DIRECTION.D);

        try {
            Thread.sleep(1000l);
        } catch (Exception e) {
        }

        map.moveCursor(DIRECTION.D);

        try {
            Thread.sleep(1000l);
        } catch (Exception e) {
        }

        map.moveCursor(DIRECTION.R);

        try {
            Thread.sleep(1000l);
        } catch (Exception e) {
        }

        map.moveCursor(DIRECTION.R);

        try {
            Thread.sleep(1000l);
        } catch (Exception e) {
        }

        map.moveCursor(DIRECTION.R);

        try {
            Thread.sleep(1000l);
        } catch (Exception e) {
        }

        map.moveCursor(DIRECTION.D);
    }
}
