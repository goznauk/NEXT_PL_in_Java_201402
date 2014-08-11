package goznauk.pl_in_java.mid_term.maze.solution;

import goznauk.pl_in_java.mid_term.maze.data.BLOCKTYPE;
import goznauk.pl_in_java.mid_term.maze.data.Coordinate;
import goznauk.pl_in_java.mid_term.maze.data.DIRECTION;
import goznauk.pl_in_java.mid_term.maze.model.Map;
import goznauk.pl_in_java.mid_term.maze.view.MapView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by goznauk on 2014. 8. 5..
 */
public class FloodFillSolution implements ISolution {
    private Map model;
    private MapView view;
    private boolean is4Way;
    private boolean stopFlag;
    List<Coordinate> shortestPath;
    List<Thread> threads;


    public FloodFillSolution(Map model, MapView view, boolean is4Way) {
        this.model = model;
        this.view = view;
        this.is4Way = is4Way;
    }

    @Override
    public void init() {
        stopFlag = false;
    }

    @Override
    public void solve() {
        threads = new ArrayList<Thread>();
        List<Coordinate> path = new ArrayList<Coordinate>();
        path.add(new Coordinate(0, 0));
        shortestPath = new ArrayList<Coordinate>();

        moveToPossibleDirection(0, path);
    }

    @Override
    public void stop() {
        stopFlag = true;
        for(Thread t : threads) {
            if (t != null) {
                t.interrupt();
            }
        }
    }

    public void moveToPossibleDirection(int index, List<Coordinate> path) {
        if(stopFlag) {
            return;
        }

        Coordinate pos = path.get(index);

        if(is4Way) {
            for (int i = 0; i < 4; i++) {
                if (model.canMoveCursor(pos, DIRECTION.values()[i])) {
                    final List<Coordinate> tmpPath = new ArrayList<Coordinate>();
                    for (Coordinate c : path) {
                        tmpPath.add(c.clone());
                    }

                    Coordinate tmpPos = pos.addDirection(DIRECTION.values()[i]);
                    model.setCursor(tmpPos);
                    tmpPath.add(tmpPos);

                    if (model.isSolved(tmpPos)) {
                        stopFlag = true;
                        shortestPath = tmpPath;

                        if (model.tryInit()) {
                            view.init(model);

                            for (int j = 0; j < shortestPath.size(); j++) {
                                if (j == 0) {
                                    continue;
                                }
                                model.setPath(shortestPath.get(j-1));
                                model.setCursor(shortestPath.get(j));
                                sleep();
                            }
                            return;
                        }
                    }

                    final int next = index + 1;

                    Runnable runnable = new Runnable() {
                        @Override
                        public void run() {
                            sleep();
                            moveToPossibleDirection(next, tmpPath);

                            if (!stopFlag) {
                                sleep();
                            }
                        }
                    };
                    Thread t = new Thread(runnable);
                    t.start();
                    threads.add(t);
                }
            }
        } else {
            for (int i = 0; i < 8; i++) {
                if (model.canMoveCursor(pos, DIRECTION.values()[i])) {
                    final List<Coordinate> tmpPath = new ArrayList<Coordinate>();
                    for (Coordinate c : path) {
                        tmpPath.add(c.clone());
                    }

                    Coordinate tmpPos = pos.addDirection(DIRECTION.values()[i]);
                    model.setCursor(tmpPos);
                    tmpPath.add(tmpPos);

                    if (model.isSolved(tmpPos)) {
                        stopFlag = true;
                        shortestPath = tmpPath;

                        if (model.tryInit()) {
                            view.init(model);

                            for (int j = 0; j < shortestPath.size(); j++) {
                                if (j == 0) {
                                    continue;
                                }
                                model.setPath(shortestPath.get(j-1));
                                model.setCursor(shortestPath.get(j));
                                sleep();
                            }
                            return;
                        }
                    }

                    final int next = index + 1;

                    Runnable runnable = new Runnable() {
                        @Override
                        public void run() {
                            sleep();
                            moveToPossibleDirection(next, tmpPath);

                            if (!stopFlag) {
                                sleep();
                            }
                        }
                    };
                    Thread t = new Thread(runnable);
                    t.start();
                    threads.add(t);
                }
            }
        }
    }

    private void sleep() {
        try {
            Thread.sleep(200);
        } catch (Exception e) {
        }
    }
}
