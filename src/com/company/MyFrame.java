package com.company;

import javax.swing.*;

/**
 * author @pater
 */
public class MyFrame extends JFrame {
    public MyFrame() {
        super("Rysowanie");
        JPanel panel = new MyPanel();
        setResizable(false);
        add(panel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}