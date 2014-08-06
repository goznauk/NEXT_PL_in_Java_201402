package goznauk.pl_in_java.mid_term.maze.view;

import goznauk.pl_in_java.mid_term.maze.model.IModel;
import goznauk.pl_in_java.mid_term.maze.data.Block;

import javax.swing.*;
import java.awt.*;

/**
 * Created by goznauk on 2014. 8. 3..
 */
public class MapView implements IView {
    JFrame jFrame = new JFrame("Class : " + getClass());
    JLabel[] labels = null;
    Container container;
    int width, height;

    public MapView() {

    }

    public void init(IModel model) {
        width = model.getMapWidth();
        height = model.getMapHeight();
        int id;

        jFrame.setLayout(new GridLayout(height, width));
        container = jFrame.getContentPane();
        labels = new JLabel[height*width];

        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                id = getComponentId(x, y);
                labels[id] = new JLabel(getBlockIcon(model.getBlock(x, y)), JLabel.CENTER);
                labels[id].setBorder(BorderFactory.createEmptyBorder());

                container.add(labels[id]);
            }
        }

        //프레임 크기 지정하기
        jFrame.setSize(25*width, 25*height);


       // onModelUpdated(model);

        //프레임 보이기
        jFrame.setVisible(true);



        //종료버튼에 대한 설정
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
   //     jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void onModelUpdated(IModel model) {
        int id;

        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                id = getComponentId(x, y);
                labels[id].setText(getBlockIcon(model.getBlock(x, y)));
            }
        }
        container.validate();
        jFrame.setVisible(true);
    }

    private String getBlockIcon(Block block) {
        switch (block.getType()) {
            case CURSOR: return "@";
            case PATH: return " ";
            case WALL: return "#";
            default: return "0";
        }
    }

    private int getComponentId(int x, int y) {
        return (y*width) + x;
    }

}
