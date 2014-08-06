package goznauk.pl_in_java.mid_term.maze.solution;

import goznauk.pl_in_java.mid_term.maze.data.DIRECTION;
import goznauk.pl_in_java.mid_term.maze.model.IModel;

/**
 * Created by goznauk on 2014. 8. 4..
 */
public class BruteForceSolution implements ISolution {
    private IModel model;
    private boolean is4Way;
    public Thread thread;

    public BruteForceSolution(IModel model, boolean is4Way) {
        this.model = model;
        this.is4Way = is4Way;
    }

    @Override
    public void solve() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    for(;;) {
                        if (model.tryMoveCursor(getRandomDirection())) {
                            try {
                                Thread.sleep(100);
                            } catch (Exception e) {
                            }
                        }
                        if(model.isSolved()) {
                            System.out.println("Solved");
                            return;
                        }
                    }
                }
                while(Thread.currentThread().isInterrupted()) {
                    System.out.println("fuck");
                }
            }
        };
        thread = new Thread(r);
        thread.start();

    }

    @Override
    public void stop() {
        //thread.interrupt();
        thread.stop();
    }

    private DIRECTION getRandomDirection() {
        int r = (int)(Math.random()*100);

        if(is4Way) {
            if (r < 30) {
                return DIRECTION.D;
            } else if (r < 60) {
                return DIRECTION.R;
            } else if (r < 80) {
                return DIRECTION.U;
            } else if (r < 100) {
                return DIRECTION.L;
            }
        } else {
            //TODO 8way
            return DIRECTION.DR;
        }
        return null;
    }
}
