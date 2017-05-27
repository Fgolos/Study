package com.home.swingGUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by FDR on 23.05.2017.
 */
public class SwingDemo {
    SwingDemo() {
        JFrame jFrame = new JFrame("Простое СВИНГ приложение");
        jFrame.setSize(245, 245);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //главный фрейм
        JLabel jLabel = new JLabel("привет Егорка. Это гуй из книжки");
        JButton test = new JButton("TEST");
        JButton test2 = new JButton("TEST");


        jFrame.add(jLabel, BorderLayout.EAST);// добавили на главный фрейм
        jFrame.add(test, BorderLayout.WEST);
        jFrame.add(test2, BorderLayout.NORTH);
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingDemo();
            }
        });
    }
}
