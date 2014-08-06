package goznauk.pl_in_java.mid_term.entry;


import goznauk.pl_in_java.mid_term.maze.controller.Controller;

import javax.naming.ldap.Control;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;


/**
 * Created by goznauk on 2014. 8. 6..
 */
public class Entry extends JFrame {
    JPanel titlePanel, mapPanel, modePanel, solutionPanel, buttonPanel;
    int option;
    String path;



    public Entry() {
        super("Goznauk's Maze Program");
        Container container = this.getContentPane();

        setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        setBounds(100, 50, 400, 270);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DefaultFocusManager d = new DefaultFocusManager();



        ArrayList<JPanel> panels = new ArrayList<JPanel>();

        titlePanel = new JPanel();
        titlePanel.add(new JLabel("Select the Option"));
        panels.add(titlePanel);


        // mapPanel
        mapPanel = new JPanel();
        mapPanel.setLayout(new GridLayout(1, 0));
        mapPanel.setBorder(BorderFactory.createTitledBorder("MAP"));

        path = "map.csv";
        JLabel mapPathLabel = new JLabel("   " + path);

        //TODO Set mapPathLabel to get max width
        JPanel mapButtonPanel = new JPanel();
        mapButtonPanel.setLayout(new GridLayout(1,0));

        JButton selectButton = new JButton("Select");
        JButton makeButton = new JButton("Make");

  //      selectButton.setFocusPainted(false);



        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("select clicked");
                if(isFocusOwner()) {
                    System.out.println("focused");
                }
            }
        });


        makeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
                    option = (option/16) * 16;
                    option += 1;
                    System.out.println("option now" + option);

                }
            }
        });

        check8Way.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==1) {
                    option = (option/16) * 16;
                    option += 2;
                    System.out.println("option now" + option);

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

                    option = option % 16;
                    option += 0x10;
                    System.out.println("option now" + option);
                }
            }
        });

        checkBruteForce.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==1) {
                    option = option % 16;
                    option += 0x20;
                    System.out.println("option now" + option);
                }
            }
        });

        checkAStar.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1) {
                    option = option % 16;
                    option += 0x30;
                    System.out.println("option now" + option);
                }
            }
        });

        checkFloodFill.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1) {
                    option = option % 16;
                    option += 0x40;
                    System.out.println("option now" + option);
                }
            }
        });

        checkBruteForce.setSelected(true);

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
                startController();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


        startButton.requestFocus();

        buttonInnerPanel.add(startButton);
        buttonInnerPanel.add(exitButton);
        buttonPanel.add(buttonInnerPanel);
        panels.add(buttonPanel);

        for(JPanel panel : panels) {
            container.add(panel);
            panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, getMinimumSize().height));
        }

        setVisible(true);

        System.out.println(getFocusOwner());

        System.out.println(startButton.isFocusOwner());
    }

    //TODO refactor
    public void startController() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                Controller controller = new Controller();
            }
        };
        Thread t = new Thread(r);
        t.start();

    }
}
