package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * author @pater
 */
public class MyPanel extends JPanel {
    
    Board board;
    
    public MyPanel() {
        createImage(800, 600);
        
        board = new Board();
        board.createNewBoard(30);
        
        setPreferredSize(new Dimension(800, 600));
        
        Kid kid = new Kid();
        
        
    }
    @Override
    protected void paintComponent(Graphics g) {
        Kid kid;
        
        super.paintComponent(g);
        for( int i = 0; i < 12; ++i){
            kid = new Kid();
            
            Point point = board.setToRandomEmptyPlace(kid);
            
            g.drawImage(kid.getIcon(),point.x * 48, point.y * 48,
                    point.x * 48+ 48, point.y * 48+ 48,
                    point.x * 48, point.y * 48,
                    point.x * 48+ 48,  point.y * 48+ 48,  null);
        }
    }
    
    
    

    
    
}
