package goznauk.pl_in_java.mid_term.controller;

import goznauk.pl_in_java.mid_term.model.DIRECTION;
import goznauk.pl_in_java.mid_term.model.IMap;
import goznauk.pl_in_java.mid_term.view.IView;

/**
 * Created by goznauk on 2014. 8. 3..
 */
public class ManualController implements IController {
    private final IMap map;
    private final IView view;

    public ManualController(IMap map, IView view) {
        this.map = map;
        this.view = view;
        view.init(map);

        try { Thread.sleep(1000l); } catch(Exception e) { }

        map.moveCursor(DIRECTION.D);
        view.onModelUpdated(map);

        try { Thread.sleep(1000l); } catch(Exception e) { }

        map.moveCursor(DIRECTION.R);
        view.onModelUpdated(map);

        try { Thread.sleep(1000l); } catch(Exception e) { }

        map.moveCursor(DIRECTION.R);
        view.onModelUpdated(map);

        try { Thread.sleep(1000l); } catch(Exception e) { }

        map.moveCursor(DIRECTION.D);
        view.onModelUpdated(map);

        try { Thread.sleep(1000l); } catch(Exception e) { }

        map.moveCursor(DIRECTION.R);
        view.onModelUpdated(map);

        try { Thread.sleep(1000l); } catch(Exception e) { }

        map.moveCursor(DIRECTION.R);
        view.onModelUpdated(map);

        try { Thread.sleep(1000l); } catch(Exception e) { }

        map.moveCursor(DIRECTION.U);
        view.onModelUpdated(map);

        try { Thread.sleep(1000l); } catch(Exception e) { }

        map.moveCursor(DIRECTION.R);
        view.onModelUpdated(map);

        try { Thread.sleep(1000l); } catch(Exception e) { }

        map.moveCursor(DIRECTION.R);
        view.onModelUpdated(map);

        try { Thread.sleep(1000l); } catch(Exception e) { }

        map.moveCursor(DIRECTION.D);
        view.onModelUpdated(map);

        try { Thread.sleep(1000l); } catch(Exception e) { }

        map.moveCursor(DIRECTION.D);
        view.onModelUpdated(map);

        try { Thread.sleep(1000l); } catch(Exception e) { }

        map.moveCursor(DIRECTION.D);
        view.onModelUpdated(map);

        try { Thread.sleep(1000l); } catch(Exception e) { }

        map.moveCursor(DIRECTION.L);
        view.onModelUpdated(map);

        try { Thread.sleep(1000l); } catch(Exception e) { }

        map.moveCursor(DIRECTION.L);
        view.onModelUpdated(map);

        try { Thread.sleep(1000l); } catch(Exception e) { }

        map.moveCursor(DIRECTION.D);
        view.onModelUpdated(map);

        try { Thread.sleep(1000l); } catch(Exception e) { }

        map.moveCursor(DIRECTION.D);
        view.onModelUpdated(map);

        try { Thread.sleep(1000l); } catch(Exception e) { }

        map.moveCursor(DIRECTION.R);
        view.onModelUpdated(map);

        try { Thread.sleep(1000l); } catch(Exception e) { }

        map.moveCursor(DIRECTION.R);
        view.onModelUpdated(map);

        try { Thread.sleep(1000l); } catch(Exception e) { }

        map.moveCursor(DIRECTION.R);
        view.onModelUpdated(map);

        try { Thread.sleep(1000l); } catch(Exception e) { }

        map.moveCursor(DIRECTION.D);
        view.onModelUpdated(map);
    }
}
