package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * author @pater
 */
public class MyPanel extends JPanel implements ActionListener {
    private Timer timer;
    private Board board;
    private ArrayList<Kid> kids = new ArrayList<>();
    private Santa santa;
    private final int DELAY = 20;
    
    public MyPanel() {
        createBoard();
        createSanta();
        createKids();
        createTimer();
        setPreferredSize(new Dimension(800, 600));
        setFocusable(true);
        addKeyListener(new TAdapter());
    }
    
    private void createBoard() {
        board = new Board();
        board.createNewBoard(Configuration.BOARD_SIZE);
    }

    private void createSanta() {
        santa = new Santa();
        Point point = board.setToRandomEmptyPlace(santa);
        santa.setPosition(point);
    }

    private void createTimer() {
        timer = new Timer(DELAY, this);
        timer.start();
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
        
        if( board.get(santa.position) != null && board.get(santa.position) != santa )System.out.println("kolizja");
        
        g.drawImage(santa.getIcon(),santa.position.x * 26, santa.position.y * 20, 24, 24,  null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        santa.move();
        repaint();
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            santa.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            santa.keyPressed(e);
        }
    }
}
