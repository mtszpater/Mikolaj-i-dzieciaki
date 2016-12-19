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
    private final int DELAY = 20;
    
    MyPanel() {
        createBoard();
        createSanta();
        createKids();
        createTimer();
        setPreferredSize(new Dimension(Configuration.WIDTH, Configuration.HEIGHT));
        setFocusable(true);
        addKeyListener(new SantaKeyAdapter(santa));
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
        timer = new Timer(DELAY, this);
        timer.start();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBackground(g);
        checkIfKidGetGift();
        drawKids(g);
        drawGifts(g);
        drawSanta(g);
    }

    private void drawBackground(Graphics g) {
        g.drawImage(new IconMaker(Configuration.BACKGROUND).createImageIcon(), 0,0, Configuration.WIDTH, Configuration.HEIGHT ,null);
    }

    private void checkIfKidGetGift() {
        KidsHandler.getInstance().checkIfKidGetGift();
    }

    private void drawKids(Graphics g) {
        KidsHandler.getInstance().drawKids(g);
    }
    
    private void drawGifts(Graphics g) {
        GiftHandler.getInstance().drawGifts(g);
    }

    private void drawSanta(Graphics g) {
        g.drawImage(santa.getIcon(),santa.position.x * Configuration.WIDTH_SCALE, santa.position.y * Configuration.HEIGHT_SCALE, Configuration.ICON_SIZE, Configuration.ICON_SIZE,  null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        santa.move();
        repaint();
    }
    
}
