package goznauk.pl_in_java.mid_term.view;

import goznauk.pl_in_java.mid_term.data.Block;
import goznauk.pl_in_java.mid_term.model.IModel;

/**
 * Created by goznauk on 2014. 8. 3..
 */
public class View implements IView {

    @Override
    public void init(IModel model) {
        clearConsole();
    }

    public void onModelUpdated(IModel model) {
        updateView(model);
    }

    public void updateView(IModel model) {
        clearConsole();

        System.out.print("| ");
        for(int x = 1; x < model.getMapWidth(); x++) {
            System.out.print('-');
        }
        System.out.print('+');
        System.out.println();

        for(int y = 0; y < model.getMapHeight(); y++) {
            System.out.print('|');
            for(int x = 0; x < model.getMapWidth(); x++) {
                System.out.print(getBlockIcon(model.getBlock(x, y)));
            }
            System.out.print('|');
            System.out.println();
        }

        System.out.print('+');
        for(int x = 0; x < model.getMapWidth()-1; x++) {
            System.out.print('-');
        }
        System.out.print(" |");
        System.out.println();

    }

    private char getBlockIcon(Block block) {
        switch (block.getType()) {
            case CURSOR: return '@';
            case PATH: return ' ';
            case WALL: return '#';
            default: return '0';
        }
    }


    private void clearConsole() {
        //Doesn't Work
        /*
        try {
            String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            //  Handle any exceptions.
        }*/
        for(int i = 0 ; i < 12; i++) {
            System.out.println();
        }

    }
}
