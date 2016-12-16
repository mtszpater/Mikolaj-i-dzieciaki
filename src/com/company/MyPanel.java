package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * author @pater
 */
public class MyPanel extends JPanel {
    public MyPanel() {
        Board board = new Board();
        board.createNewBoard(30);
        
        setPreferredSize(new Dimension(800, 600));
        
        Kid kid = new Kid();
        JLabel label = new JLabel( kid.getIcon(), JLabel.CENTER);
        
        add(label);
    }
    
    
    
}
