package com.company.gui;

import com.company.*;
import com.company.Point;
import com.company.characters.Gift;
import com.company.characters.Kid;
import com.company.characters.Santa;
import com.company.listeners.SantaKeyAdapter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * author @pater
 */
class MyPanel extends JPanel implements ActionListener {
    private Timer timer;
    private Board board;
    private ArrayList<Kid> kids = new ArrayList<>();
    private Santa santa;
    private final int DELAY = 20;
    
    MyPanel() {
        createBoard();
        createSanta();
        createKids();
        createTimer();
        setPreferredSize(new Dimension(800, 600));
        setFocusable(true);
        addKeyListener(new SantaKeyAdapter(santa));
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

    private void createKids(){
        Kid kid;

        int i = 0;
        while (i < Configuration.NUMBER_OF_CHILDREN) {
            kid = new Kid();
            Point point = board.setToRandomEmptyPlace(kid);
            kid.setPosition(point);
            kid.initMoving();
            kids.add(kid);
            ++i;
        }
    }
    
    private void createTimer() {
        timer = new Timer(DELAY, this);
        timer.start();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(new IconMaker(Configuration.BACKGROUND).createImageIcon(), 0,0, 800, 600 ,null);
        
        drawKids(g);
        drawGifts(g);
        checkIfKidGetGift();
        drawSanta(g);
    }

    private void drawKids(Graphics g) {
        Kid kid;
        for(int i = 0; i < Configuration.NUMBER_OF_CHILDREN; ++i){
            kid = kids.get(i);

            if( kid.grounded )
                g.drawImage(kid.getIcon(), kid.position.x * 26, kid.position.y * 20, 24, 24,  Color.MAGENTA ,null);
            else
                g.drawImage(kid.getIcon(), kid.position.x * 26, kid.position.y * 20, 24, 24 ,null);

        }
    }
    
    private void drawGifts(Graphics g) {
        GiftHandler giftHandler = GiftHandler.getInstance();
        Gift gift;
        
        for( int i = 0; i < giftHandler.getCount(); ++i){
            gift = giftHandler.getGiftByIndex(i);
            g.drawImage(gift.getIcon(), gift.position.x * 26, gift.position.y * 20, 24, 24,  null);
        }
    }

    private void checkIfKidGetGift() {
        GiftHandler giftHandler = GiftHandler.getInstance();
        Gift gift;

        for( int i = 0; i < giftHandler.getCount(); ++i){
            gift = giftHandler.getGiftByIndex(i);

            Kid thisKid = AreaScanner.getKidFromNeighborhood(kids, gift);
            if (thisKid != null) {
                thisKid.setAsGrounded(gift);
            }
        }
    }

    private void drawSanta(Graphics g) {
        g.drawImage(santa.getIcon(),santa.position.x * 26, santa.position.y * 20, 24, 24,  null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        santa.move();
        repaint();
    }
    
}
