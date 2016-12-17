package com.company;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
        addKeyListener(
                new KeyListener() {
                    public void keyTyped(KeyEvent e) {
                    }
                    
                    public void keyPressed(KeyEvent e) {
                        if( e.getKeyCode() == 40 ) System.out.println( "DOWN" ); 
                        if( e.getKeyCode() == 39 ) System.out.println( "RIGHT" ); 
                        if( e.getKeyCode() == 37 ) System.out.println( "LEFT" ); 
                        if( e.getKeyCode() == 38 ) System.out.println( "UP" ); 
                    }
                    
                    public void keyReleased(KeyEvent e) {
                    }
                }
        );
        setVisible(true);
    }
}