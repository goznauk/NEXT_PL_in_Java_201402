package goznauk.pl_in_java.mid_term.maze.solution;

import goznauk.pl_in_java.mid_term.maze.data.DIRECTION;
import goznauk.pl_in_java.mid_term.maze.model.Map;

/**
 * Created by goznauk on 2014. 8. 4..
 */
public class BruteForceSolution implements ISolution {
    static final int COUTN_MAX = 10000;

    private Map model;
    private boolean is4Way;
    public Thread thread;
    private boolean stopFlag;
    private Runnable runnable;

    int count = 0;

    public BruteForceSolution(Map model, boolean is4Way) {
        this.model = model;
        this.is4Way = is4Way;
    }


    @Override
    public void init() {
        stopFlag = false;
    }

    @Override
    public void solve() {

        runnable = new Runnable() {
            @Override
            public void run() {
                while (!stopFlag) {
                    if (model.tryMoveCursor(getRandomDirection())) {
                        try {
                            count++;
                            Thread.sleep(10);
                        } catch (Exception e) {
                        }
                    }
                    if (model.isSolved()) {
                        System.out.println("Solved");
                        return;
                    }
                    if (count > COUTN_MAX) {
                        System.out.println("Cannot solve");
                        stop();
                    }
                }
            }
        };
        thread = new Thread(runnable);
        thread.start();
    }

    @Override
    public void stop() {
        System.out.println("solution.stop()");
        stopFlag = true;
        thread.interrupt();
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
            if(r < 20) {
                return DIRECTION.DR;
            } else if(r < 35) {
                return DIRECTION.D;
            } else if(r < 50) {
                return DIRECTION.R;
            } else if(r < 60) {
                return DIRECTION.UR;
            } else if(r < 70) {
                return DIRECTION.U;
            } else if(r < 80) {
                return DIRECTION.UL;
            } else if(r < 90) {
                return DIRECTION.L;
            } else if(r < 100) {
                return DIRECTION.DL;
            }
        }
        return null;
    }
}
