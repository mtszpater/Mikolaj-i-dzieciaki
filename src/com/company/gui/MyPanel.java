package com.company.gui;

import com.company.*;
import com.company.Point;
import com.company.characters.Santa;
import com.company.listeners.SantaKeyAdapter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * author @pater
 */
class MyPanel extends JPanel implements ActionListener {
    private Timer timer;
    private Board board;
    private Santa santa;
    private Drawer drawer;
    
    MyPanel() {
        createComponents();
        setPreferredSize(new Dimension(Configuration.WIDTH, Configuration.HEIGHT));
        setFocusable(true);
        addKeyListener(new SantaKeyAdapter(santa));
    }

    public void createComponents() {
        createBoard();
        createSanta();
        createKids();
        createTimer();
    }

    private void createBoard() {
        board = new Board();
        board.createNewBoard(Configuration.BOARD_SIZE);
    }

    private void createSanta() {
        santa = Santa.getInstance();
        Point point = board.setToRandomEmptyPlace(santa);
        santa.setPosition(point);
    }

    private void createKids(){
        KidsHandler.getInstance().createKids(board);
    }
    
    private void createTimer() {
        timer = new Timer(Configuration.DELAY, this);
        timer.start();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawer = new Drawer(g);
        drawer.drawBackground();
        drawer.drawKids();
        drawer.drawGifts();
        drawer.drawSanta();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SantaHunting gameStatus = SantaHunting.getInstance();
        
        if( gameStatus.isActive() ) {
            santa.move();
            gameStatus.updateStatus();
            repaint();
        }
        else
        {
            gameStatus.showResult();
        }
    }
    
}
