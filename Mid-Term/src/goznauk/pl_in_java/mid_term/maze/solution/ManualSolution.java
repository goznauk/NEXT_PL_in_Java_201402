package goznauk.pl_in_java.mid_term.maze.solution;

import goznauk.pl_in_java.mid_term.maze.data.DIRECTION;
import goznauk.pl_in_java.mid_term.maze.model.Map;
import goznauk.pl_in_java.mid_term.maze.view.MapView;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by goznauk on 2014. 8. 11..
 */
public class ManualSolution implements ISolution {
    private Map model;
    private MapView view;
    private boolean is4Way;
    private KeyAdapter keyAdapter;

    public ManualSolution(Map model, MapView view, boolean is4Way) {
        this.model = model;
        this.view = view;
        this.is4Way = is4Way;
    }

    @Override
    public void init() {
        if(is4Way) {
            keyAdapter = new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    super.keyPressed(e);
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_UP:
                            model.tryMoveCursor(DIRECTION.U);
                            break;
                        case KeyEvent.VK_DOWN:
                            model.tryMoveCursor(DIRECTION.D);
                            break;
                        case KeyEvent.VK_LEFT:
                            model.tryMoveCursor(DIRECTION.L);
                            break;
                        case KeyEvent.VK_RIGHT:
                            model.tryMoveCursor(DIRECTION.R);
                            break;
                    }
                    if (model.isSolved()) {
                        System.out.println("Solved!");
                        view.removeKeyListener(this);
                    }
                }
            };
        } else {
            keyAdapter = new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    super.keyPressed(e);
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_W:
                            model.tryMoveCursor(DIRECTION.U);
                            break;
                        case KeyEvent.VK_X:
                            model.tryMoveCursor(DIRECTION.D);
                            break;
                        case KeyEvent.VK_A:
                            model.tryMoveCursor(DIRECTION.L);
                            break;
                        case KeyEvent.VK_D:
                            model.tryMoveCursor(DIRECTION.R);
                            break;
                        case KeyEvent.VK_Q:
                            model.tryMoveCursor(DIRECTION.UL);
                            break;
                        case KeyEvent.VK_E:
                            model.tryMoveCursor(DIRECTION.UR);
                            break;
                        case KeyEvent.VK_Z:
                            model.tryMoveCursor(DIRECTION.DL);
                            break;
                        case KeyEvent.VK_C:
                            model.tryMoveCursor(DIRECTION.DR);
                            break;
                    }
                    if (model.isSolved()) {
                        System.out.println("Solved!");
                        view.removeKeyListener(this);
                    }
                }
            };
        }
    }

    @Override
    public void solve() {
        view.addKeyListener(keyAdapter);
        view.requestFocus();
    }

    @Override
    public void stop() {
        view.removeKeyListener(keyAdapter);
    }
}
