package goznauk.pl_in_java.mid_term.entry;

import goznauk.pl_in_java.mid_term.maze.Maze;
import goznauk.pl_in_java.mid_term.maze.controller.Controller;

/**
 * Created by goznauk on 2014. 8. 8..
 */
public class Entry {
    private EntryView entryView;
    private int option;
    private String mapPath;
    private Controller controller;
    private Maze maze;

    public Entry() {
        entryView = new EntryView();
        maze = new Maze();

        ViewCallbackEvent viewCallbackEvent = new ViewCallbackEvent() {
            @Override
            public void onOptionChanged() {
                option = entryView.getOption();
            }

            @Override
            public void onMapPathChanged() {
                mapPath = entryView.getMapPath();
            }

            @Override
            public void onStartButtonClicked() {
                maze.add(option, mapPath);
            }

            @Override
            public void onExitButtonClicked() {
                maze.exitAll();
                System.exit(0);
            }
        };
        entryView.setViewCallbackEvent(viewCallbackEvent);
    }
}
