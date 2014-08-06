package goznauk.pl_in_java.mid_term.maze.view;

import goznauk.pl_in_java.mid_term.maze.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by goznauk on 2014. 8. 5..
 */
public class OptionView {
    //TODO Modify
    JFrame jFrame = new JFrame("Maze");
    JButton[] buttons = null;
    JCheckBox[] checkBoxes = null;
    JLabel[] labels = null;
    Container container;



    public void initialize(final Controller c) {
        jFrame.setLayout(new GridLayout(5, 2));
        container = jFrame.getContentPane();

        buttons = new JButton[4];
        buttons[0] = new JButton("Manual");
        buttons[1] = new JButton("Brute Force");
        buttons[2] = new JButton("A Star");
        buttons[3] = new JButton("Flood fill");

        checkBoxes = new JCheckBox[2];
        checkBoxes[0] = new JCheckBox("4 way");
        checkBoxes[1] = new JCheckBox("8 way");

        labels = new JLabel[4];
        labels[0] = new JLabel("Direction Number");
        labels[1] = new JLabel("");
        labels[2] = new JLabel("Choose Method");
        labels[3] = new JLabel("");

        container.add(labels[0]);
        container.add(labels[1]);
        container.add(checkBoxes[0]);
        container.add(checkBoxes[1]);
        container.add(labels[2]);
        container.add(labels[3]);

        for(JButton b : buttons) {
            container.add(b);

            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    c.setSolution(0x21);

                    c.execute();
                    System.out.println("Button Clicked");
                }
            });
        }

        jFrame.setSize(300, 600);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
