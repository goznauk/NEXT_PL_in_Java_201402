package goznauk.pl_in_java.mid_term.entry;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;


/**
 * Created by goznauk on 2014. 8. 6..
 */
public class EntryView extends JFrame {

    public static int DIR_4 = 0x01;
    public static int DIR_8 = 0x02;
    public static int MODE_MANUAL = 0x10;
    public static int MODE_BRUTEFORCE = 0x20;
    public static int MODE_ASTAR = 0x30;
    public static int MODE_FLOODFILL = 0x40;


    JPanel titlePanel, mapPanel, modePanel, solutionPanel, buttonPanel;
    private int option;
    private String mapPath;


    private ViewCallbackEvent viewCallbackEvent;

    public void setViewCallbackEvent(ViewCallbackEvent event) {
        viewCallbackEvent = event;
    }


    public EntryView() {

        //GUI stuffs
        super("Goznauk's Maze Program");
        Container container = this.getContentPane();

        setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        setBounds(20, 20, 400, 270);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ArrayList<JPanel> panels = new ArrayList<JPanel>();

        // titlePanel
        titlePanel = new JPanel();
        titlePanel.add(new JLabel("Select the Option"));
        panels.add(titlePanel);

        // mapPanel
        mapPanel = new JPanel();
        mapPanel.setLayout(new GridLayout(1, 0));
        mapPanel.setBorder(BorderFactory.createTitledBorder("MAP"));

        mapPath = "map.csv";
        JLabel mapPathLabel = new JLabel("   " + mapPath);

        JPanel mapButtonPanel = new JPanel();
        mapButtonPanel.setLayout(new GridLayout(1,0));

        JButton selectButton = new JButton("Select");
        JButton makeButton = new JButton("Make");

        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("select clicked");
            }
        });

        makeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("make clicked");
            }
        });

        mapButtonPanel.add(selectButton);
        mapButtonPanel.add(makeButton);

        mapPanel.add(mapPathLabel);
        mapPanel.add(mapButtonPanel);
        panels.add(mapPanel);

        // modePanel
        modePanel = new JPanel();
        modePanel.setBorder(BorderFactory.createTitledBorder("MODE"));
        modePanel.setLayout(new GridLayout(0,2));

        JCheckBox check4Way = new JCheckBox("4 Way");
        JCheckBox check8Way = new JCheckBox("8 Way");

        check4Way.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==1) {
                    setDirNum(DIR_4);
                }
            }
        });

        check8Way.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==1) {
                    setDirNum(DIR_8);
                }
            }
        });

        check4Way.setSelected(true);

        ButtonGroup modelCheckBoxes = new ButtonGroup();
        modelCheckBoxes.add(check4Way);
        modelCheckBoxes.add(check8Way);

        modePanel.add(check4Way);
        modePanel.add(check8Way);
        panels.add(modePanel);

        // solutionPanel
        solutionPanel = new JPanel();
        solutionPanel.setBorder(BorderFactory.createTitledBorder("SOLUTION"));
        solutionPanel.setLayout(new GridLayout(2,2));

        JCheckBox checkManual = new JCheckBox("MANUAL");
        JCheckBox checkBruteForce = new JCheckBox("BRUTE FORCE");
        JCheckBox checkAStar = new JCheckBox("A STAR");
        JCheckBox checkFloodFill = new JCheckBox("FLOOD FILL");

        checkManual.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1) {
                    setMode(MODE_MANUAL);
                }
            }
        });

        checkBruteForce.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==1) {
                    setMode(MODE_BRUTEFORCE);
                }
            }
        });

        checkAStar.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1) {
                    setMode(MODE_ASTAR);
                }
            }
        });

        checkFloodFill.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1) {
                    setMode(MODE_FLOODFILL);
                }
            }
        });

        checkManual.setSelected(true);

        ButtonGroup solutionCheckBoxes = new ButtonGroup();
        solutionCheckBoxes.add(checkManual);
        solutionCheckBoxes.add(checkBruteForce);
        solutionCheckBoxes.add(checkAStar);
        solutionCheckBoxes.add(checkFloodFill);

        solutionPanel.add(checkManual);
        solutionPanel.add(checkBruteForce);
        solutionPanel.add(checkAStar);
        solutionPanel.add(checkFloodFill);

        panels.add(solutionPanel);

        // buttonPanel
        buttonPanel = new JPanel();
        JPanel buttonInnerPanel = new JPanel();

        buttonInnerPanel.setLayout(new GridLayout(1,0));

        JButton startButton = new JButton("Start");
        JButton exitButton = new JButton("Exit");

        startButton.requestFocusInWindow();

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //start controller with option
                System.out.println("Start button clicked");

                // refactor later
                viewCallbackEvent.onOptionChanged();
                viewCallbackEvent.onMapPathChanged();



                viewCallbackEvent.onStartButtonClicked();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewCallbackEvent.onExitButtonClicked();
                dispose();
            }
        });

        buttonInnerPanel.add(startButton);
        buttonInnerPanel.add(exitButton);
        buttonPanel.add(buttonInnerPanel);
        panels.add(buttonPanel);


        for(JPanel panel : panels) {
            container.add(panel);
            panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, getMinimumSize().height));
        }

        setVisible(true);
    }

    private void setDirNum(int dirNum) {
        option = (option/16) * 16;
        option += dirNum;
        System.out.println("option now" + option);
    }

    private void setMode(int mode) {
        option = option % 16;
        option += mode;
        System.out.println("option now" + option);
    }

    public int getOption() {
        return option;
    }

    public String getMapPath() {
        return mapPath;
    }

}
