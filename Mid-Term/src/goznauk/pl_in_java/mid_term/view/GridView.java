package goznauk.pl_in_java.mid_term.view;

import goznauk.pl_in_java.mid_term.model.IModel;
import goznauk.pl_in_java.mid_term.model.blocks.Block;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by goznauk on 2014. 8. 3..
 */
public class GridView implements IView, Observer {
    JFrame jFrame = new JFrame("이번엔 GridLayout이다!!");
    JLabel[] labels = null;
    Container container;
    IModel cashe;

    public GridView() {

    }

    public void init(IModel model) {
        jFrame.setLayout(new GridLayout(model.getMapHeight(), model.getMapWidth()));
        container = jFrame.getContentPane();
        labels = new JLabel[model.getMapHeight()*model.getMapWidth()];



        for(int y = 0; y < model.getMapHeight(); y++) {
            for(int x = 0; x < model.getMapWidth(); x++) {
                labels[y * model.getMapHeight() + x] = new JLabel(getBlockIcon(model.getBlock(x, y)), JLabel.CENTER);
                labels[y * model.getMapHeight() + x].setBorder(BorderFactory.createEmptyBorder());
                container.add(labels[y * model.getMapHeight() + x]);
            }
        }

        //프레임 크기 지정하기
        jFrame.setSize(200,200);


       // onModelUpdated(model);

        //프레임 보이기
        jFrame.setVisible(true);



        //종료버튼에 대한 설정
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void onModelUpdated(IModel model) {

        for(int y = 0; y < model.getMapHeight(); y++) {
            for(int x = 0; x < model.getMapWidth(); x++) {
                labels[y * model.getMapHeight() + x].setText(getBlockIcon(model.getBlock(x, y)));
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

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("update called : object arg is" + arg.getClass() + "o : " + o.getClass());
        onModelUpdated((IModel) o);
    }
}
