package goznauk.pl_in_java.mid_term.solution;

import goznauk.pl_in_java.mid_term.controller.IController;
import goznauk.pl_in_java.mid_term.model.DIRECTION;
import goznauk.pl_in_java.mid_term.model.IModel;

/**
 * Created by goznauk on 2014. 8. 4..
 */
public class BruteForceSolution implements ISolution {
    private IModel model;

    public BruteForceSolution(IModel model) {
        this.model = model;
    }

    @Override
    public void solve() {
        while(!model.isSolved()) {
            if(model.tryMoveCursor(getRandomDirection())) {
                try {
                    Thread.sleep(50l);
                } catch (Exception e) {
                }
            }
        }
        System.out.println("Solved");
    }

    private DIRECTION getRandomDirection() {
        int r = (int)(Math.random()*100);

        if(r<30) {
            return DIRECTION.D;
        } else if(r<60) {
            return DIRECTION.R;
        } else if(r<80) {
            return DIRECTION.U;
        } else if(r<100) {
            return DIRECTION.L;
        }

        return null;
    }
}
