package goznauk.pl_in_java.mid_term.entry;


import goznauk.pl_in_java.mid_term.entry.mapmaker.MapMaker;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
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


    private JLabel mapPathLabel;

    private EntryViewCallbackEvent entryViewCallbackEvent;

    public void setEntryViewCallbackEvent(EntryViewCallbackEvent event) {
        entryViewCallbackEvent = event;
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

        mapPath = "Please Select the Map Path";
        mapPathLabel = new JLabel("   " + mapPath);

        JPanel mapButtonPanel = new JPanel();
        mapButtonPanel.setLayout(new GridLayout(1,0));

        JButton selectButton = new JButton("Select");
        JButton makeButton = new JButton("Make");

        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectMapPath();
                setMapPath(mapPath);
                entryViewCallbackEvent.onMapPathChanged();
            }
        });

        makeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entryViewCallbackEvent.onMapMakeButtonClicked();
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
                // refactor later
                entryViewCallbackEvent.onOptionChanged();
                entryViewCallbackEvent.onMapPathChanged();


                entryViewCallbackEvent.onStartButtonClicked();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                entryViewCallbackEvent.onExitButtonClicked();
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

    private void selectMapPath() {
        JFileChooser fileChooser = new JFileChooser(mapPath);

        FileNameExtensionFilter filter = new FileNameExtensionFilter("csv file", "csv");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(this);
        System.out.println(result);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            mapPath = selectedFile.toString();
            System.out.println(mapPath);
        }
    }

    private void setDirNum(int dirNum) {
        option = (option/16) * 16;
        option += dirNum;
    }

    private void setMode(int mode) {
        option = option % 16;
        option += mode;
    }

    public int getOption() {
        return option;
    }

    public String getMapPath() {
        return mapPath;
    }

    public void setMapPath(String path) {
        mapPath = path;
        mapPathLabel.setText("   " + shortenPath(mapPath));
    }

    private String shortenPath(String path) {
        if(path.length() > 20) {
            return "/..." + shorten(path);
        }
        return path;
    }

    private String shorten(String path) {
        String s = path;

        if(System.getProperty("os.name").toLowerCase().indexOf("mac")>=0) {
            if (s.length() > 20) {
                s = s.substring(1);
                if(s.indexOf("/") != -1) {
                    s = s.substring(s.indexOf("/"));
                    s = shorten(s);
                }
            }
        }
        return s;
    }

}
