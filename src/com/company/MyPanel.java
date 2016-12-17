package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * author @pater
 */
public class MyPanel extends JPanel  {
    
    Board board;
    private ArrayList<Kid> kids = new ArrayList<>();
    private Santa santa;
    
    public MyPanel() {
        createBoard();
        createSanta();
        createKids();
        setPreferredSize(new Dimension(800, 600));
    }

    private void createBoard() {
        board = new Board();
        board.createNewBoard(30);
    }

    private void createSanta() {
        santa = new Santa();
        Point point = board.setToRandomEmptyPlace(santa);
        santa.setPosition(point);
    }

    private void createKids(){
        Kid kid;
        
        for( int i = 0; i < 12; ++i){
            kid = new Kid();

            Point point = board.setToRandomEmptyPlace(kid);
            kid.setPosition(point);
            
            kids.add(kid);
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Kid kid;
        for( int i = 0; i < 12; ++i){
            kid = kids.get(i);
            g.drawImage(kid.getIcon(), kid.position.x * 26, kid.position.y * 20, 24, 24,  null);
        }
        g.drawImage(santa.getIcon(),santa.position.x * 26, santa.position.y * 20, 24, 24,  null);
    }
    
    
    
}
