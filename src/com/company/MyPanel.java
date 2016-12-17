package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * author @pater
 */
public class MyPanel extends JPanel {
    
    Board board;
    
    public MyPanel() {
        
        board = new Board();
        board.createNewBoard(30);
        
        setPreferredSize(new Dimension(800, 600));
        
    }
    @Override
    protected void paintComponent(Graphics g) {
        Kid kid;
        Santa santa = new Santa();
        
        super.paintComponent(g);
        for( int i = 0; i < 12; ++i){
            kid = new Kid();
            
            Point point = board.setToRandomEmptyPlace(kid);
            
            g.drawImage(kid.getIcon(),point.x * 26, point.y * 20, 24, 24,  null);
        }

        Point point = board.setToRandomEmptyPlace(santa);
        g.drawImage(santa.getIcon(),point.x * 26, point.y * 20, 24, 24,  null);
    }
    
}
