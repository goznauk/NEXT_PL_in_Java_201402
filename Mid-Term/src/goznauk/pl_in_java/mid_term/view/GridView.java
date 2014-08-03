package goznauk.pl_in_java.mid_term.view;

import goznauk.pl_in_java.mid_term.model.IMap;
import goznauk.pl_in_java.mid_term.model.blocks.Block;

import javax.swing.*;
import java.awt.*;

/**
 * Created by goznauk on 2014. 8. 3..
 */
public class GridView implements IView {
    JFrame jFrame = new JFrame("이번엔 GridLayout이다!!");
    JButton [] btn = null;
    Container container;

    public GridView() {

    }

    public void init(IMap model) {
        jFrame.setLayout(new GridLayout(model.getMapHeight(), model.getMapWidth()));
        container = jFrame.getContentPane();
        btn = new JButton[model.getMapHeight()*model.getMapWidth()];

        for(int y = 0; y < model.getMapHeight(); y++) {
            for(int x = 0; x < model.getMapWidth(); x++) {
                btn[y * model.getMapHeight() + x] = new JButton(getBlockIcon(model.getBlock(x, y)));
                container.add(btn[y * model.getMapHeight() + x]);
            }
        }

        //프레임 크기 지정하기
        jFrame.setSize(200,200);

        //프레임 보이기
        jFrame.setVisible(true);

        //종료버튼에 대한 설정
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void onModelUpdated(IMap model) {

        //TODO ReFactor
        container.removeAll();

        for(int y = 0; y < model.getMapHeight(); y++) {
            for(int x = 0; x < model.getMapWidth(); x++) {
                //btn[y * model.getMapHeight() + x] = new JButton(x+","+y+getBlockIcon(model.getBlock(x, y)));
                btn[y * model.getMapHeight() + x] = new JButton(getBlockIcon(model.getBlock(x, y)));
                container.add(btn[y * model.getMapHeight() + x]);
            }
        }
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
}
