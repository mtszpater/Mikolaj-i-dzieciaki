package com.company.gui;

import com.company.Configuration;

import javax.swing.*;

/**
 * author @pater
 */
public class SantaHunting extends JFrame {
    public SantaHunting() {
        super(Configuration.GAME_TITLE);
        JPanel panel = new MyPanel();
        setResizable(false);
        add(panel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}