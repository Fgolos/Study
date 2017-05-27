package com.home.swingGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by FDR on 23.05.2017.
 */
public class ButtonDemo implements ActionListener {
    JLabel jlab;

    ButtonDemo() {
        JFrame jFrame = new JFrame("Пример работы с кнопками");
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(220, 90);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton upButton = new JButton("UP");
        JButton downButton = new JButton("DOWN");
        jlab = new JLabel("PRESS BUTTON");

        upButton.addActionListener(this);
        downButton.addActionListener(this);

        jFrame.add(upButton);
        jFrame.add(downButton);
        jFrame.add(jlab);

        jFrame.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ButtonDemo();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("UP"))
            jlab.setText("You press UP");
        else
            jlab.setText("You press DOWN");
    }
}
