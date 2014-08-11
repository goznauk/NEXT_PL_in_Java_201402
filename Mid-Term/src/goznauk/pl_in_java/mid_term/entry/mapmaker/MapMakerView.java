package goznauk.pl_in_java.mid_term.entry.mapmaker;

import javax.swing.*;
import javax.swing.plaf.metal.MetalToggleButtonUI;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by goznauk on 2014. 8. 11..
 */
public class MapMakerView extends JFrame {
    Container container;
    int width, height;
    JToggleButton[] toggleButtons;


    public MapMakerView() {
        super("Map Maker");
    }

    private MapMakerViewCallbackEvent mapMakerViewCallbackEvent;

    public void setMapMakerViewCallbackEvent(MapMakerViewCallbackEvent event) {
        this.mapMakerViewCallbackEvent = event;
    }

    public void init(MapMakerModel model) {
        Container container = getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        width = model.getWidth();
        height = model.getHeight();

        setBounds(500, 20, 25*width, 25*height + 40);

        // Map Info
        JPanel mapInfoPanel = new JPanel();

        int id;

        mapInfoPanel.setLayout(new GridLayout(height, width, 0, 0));
        setPreferredSize(new Dimension(25*width, 25*height));

        toggleButtons = new JToggleButton[height*width];

        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                id = getComponentId(x, y);
                toggleButtons[id] = new JToggleButton();
                toggleButtons[id].setSize(25, 25);
                toggleButtons[id].setBorder(BorderFactory.createLineBorder(Color.BLACK));

                toggleButtons[id].setUI(new MetalToggleButtonUI() {
                    @Override
                    protected Color getSelectColor() {
                        return Color.BLACK;
                    }

                });

                final int fx = x;
                final int fy = y;
                final int fid = id;

                toggleButtons[id].addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        System.out.println("toggle button clicked");
                        mapMakerViewCallbackEvent.onMapChanged(fx, fy, toggleButtons[fid].isSelected());
                    }
                });

                mapInfoPanel.add(toggleButtons[id]);
            }
        }


        container.add(mapInfoPanel);

        // Buttons
        JPanel buttonPanel = new JPanel();

        JPanel buttonInnerPanel = new JPanel();
        buttonInnerPanel.setLayout(new GridLayout(1,0));

        JButton saveButton = new JButton("Save");
        JButton exitButton = new JButton("Exit");

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Save button clicked");
                mapMakerViewCallbackEvent.onSaveButtonClicked();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
            }
        });

        buttonInnerPanel.add(saveButton);
        buttonInnerPanel.add(exitButton);
        buttonPanel.add(buttonInnerPanel);
        buttonPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, getMinimumSize().height));

        container.add(buttonPanel);

        setMinimumSize(new Dimension(200, 25*height + 40));

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.out.println("window ss");
                mapMakerViewCallbackEvent.onViewClosed();
            }
        });

        setVisible(true);
    }

    private int getComponentId(int x, int y)  {
        return (y*width) + x;
    }

    public void setUnSelected(int x, int y) {
        if(toggleButtons!=null) {
            toggleButtons[getComponentId(x, y)].setSelected(false);
        }
    }


}
