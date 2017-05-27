package com.home.swingGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by FDR on 23.05.2017.
 */
public class TFDemo implements ActionListener {
    JTextField jtf;
    JButton jButton;
    JLabel jLabel;
    JLabel jLabelContents;

    TFDemo() {
        JFrame jFrame = new JFrame("Использование текстового поля");
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(240, 120);
        jFrame.setDefaultCloseOperation(3);

        jtf = new JTextField(10);
        jtf.setActionCommand("myTF");

        jButton = new JButton("Reverce");

        jtf.addActionListener(this);
        jButton.addActionListener(this);

        jLabel = new JLabel("Введите текст");
        jLabelContents = new JLabel("");

        jFrame.add(jtf);
        jFrame.add(jButton);
        jFrame.add(jLabel);
        jFrame.add(jLabelContents);

        jFrame.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TFDemo();
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Reverce")) {
            String orgStr = jtf.getText();
            String resStr = "";
            for (int i = orgStr.length() - 1; i >= 0; i--) {
                resStr = resStr + orgStr.charAt(i);
            }
            jtf.setText(resStr);

        } else
            jLabelContents.setText("You pressed ENTER. Text is: " + jtf.getText());

    }
}
