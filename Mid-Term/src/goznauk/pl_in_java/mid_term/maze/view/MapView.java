package goznauk.pl_in_java.mid_term.maze.view;

import goznauk.pl_in_java.mid_term.maze.data.Block;
import goznauk.pl_in_java.mid_term.maze.model.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by goznauk on 2014. 8. 10..
 */
public class MapView extends JFrame{
    Container container;
    JLabel[] labels;
    int width, height;

    JLabel movedLabel;

    public MapView(String title) {
        super(title);
    }

    private MapViewCallbackEvent mapViewCallbackEvent;

    public void setMapViewCallbackEvent(MapViewCallbackEvent event) {
        mapViewCallbackEvent = event;
    }

    public void exit() {
        dispose();
    }


    public void init(Map model) {
        boolean isInitial = true;

        if(container != null) {
            isInitial = false;
            container.removeAll();
        } else {
            container = getContentPane();
            container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));

            width = model.getMapWidth();
            height = model.getMapHeight();
            setBounds(500, 20, (15 * width) + 150 + 20, 25 * height + 10);
        }

        // maze
        JPanel mazePanel = new JPanel();

        int id;

        mazePanel.setLayout(new GridLayout(height, width));
        mazePanel.setSize(15*width, 25*height);
        mazePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));

        labels = new JLabel[height*width];

        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                id = getComponentId(x, y);
                labels[id] = new JLabel(getBlockIcon(model.getBlock(x, y)), JLabel.CENTER);
                labels[id].setBorder(BorderFactory.createEmptyBorder());

                mazePanel.add(labels[id]);
            }
        }

        container.add(mazePanel);


        // details
        JPanel detailPanel = new JPanel();
        detailPanel.setLayout(new BoxLayout(detailPanel, BoxLayout.Y_AXIS));
        detailPanel.setSize(150, 25*height);
        detailPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        movedLabel = new JLabel("moved : " + model.getMoved());

        JLabel blank = new JLabel("");
        blank.setMaximumSize(new Dimension(detailPanel.getWidth(), Integer.MAX_VALUE));

        JButton restartButton = new JButton("Restart");
        restartButton.setMaximumSize(new Dimension(detailPanel.getWidth(), 30));
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mapViewCallbackEvent.onResetButtonClicked();
            }
        });


        JButton exitButton = new JButton("Exit");
        exitButton.setMaximumSize(new Dimension(detailPanel.getWidth(), 30));
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mapViewCallbackEvent.onExitButtonClicked();
            }
        });


        detailPanel.add(movedLabel);
        detailPanel.add(blank);
        detailPanel.add(restartButton);
        detailPanel.add(exitButton);

        container.add(detailPanel);



        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.out.println("window ss");
                mapViewCallbackEvent.onViewClosed();
            }
        });

        if(isInitial) {
            setVisible(true);
        }
    }



    public void onModelUpdated(Map model) {
        int id;

        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                id = getComponentId(x, y);
                labels[id].setText(getBlockIcon(model.getBlock(x, y)));
            }
        }

        movedLabel.setText("moved : " + model.getMoved());
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