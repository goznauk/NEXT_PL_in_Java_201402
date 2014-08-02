package goznauk.pl_in_java.mid_term;

import goznauk.pl_in_java.mid_term.controller.IController;
import goznauk.pl_in_java.mid_term.controller.ManualController;
import goznauk.pl_in_java.mid_term.model.IMap;
import goznauk.pl_in_java.mid_term.model.Map;
import goznauk.pl_in_java.mid_term.view.IView;
import goznauk.pl_in_java.mid_term.view.View;

public class Main {

    public static void main(String[] args) {

        IMap map = new Map();
        IView view = new View();
        IController controller = new ManualController(map, view);
    }
}
