package goznauk.pl_in_java.mid_term.entry;

import goznauk.pl_in_java.mid_term.entry.mapmaker.MapMaker;
import goznauk.pl_in_java.mid_term.entry.mapmaker.MapMakerCallbackEvent;
import goznauk.pl_in_java.mid_term.maze.Maze;

/**
 * Created by goznauk on 2014. 8. 8..
 */
public class Entry {
    private EntryView entryView;
    private int option;
    private String mapPath;
    private Maze maze;
    private MapMaker maker;

    public Entry() {
        entryView = new EntryView();
        maze = new Maze();
        maker = new MapMaker();

        EntryViewCallbackEvent entryViewCallbackEvent = new EntryViewCallbackEvent() {
            @Override
            public void onOptionChanged() {
                option = entryView.getOption();
            }

            @Override
            public void onMapPathChanged() {
                mapPath = entryView.getMapPath();
            }

            @Override
            public void onMapMakeButtonClicked() {
                maker.init(mapPath);
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

        entryView.setEntryViewCallbackEvent(entryViewCallbackEvent);


        MapMakerCallbackEvent mapMakerCallbackEvent = new MapMakerCallbackEvent() {
            @Override
            public void onMapSaved() {
                mapPath = maker.getPath();
                entryView.setMapPath(mapPath);
            }
        };

        maker.setMapMakerCallbackEvent(mapMakerCallbackEvent);
    }
}
