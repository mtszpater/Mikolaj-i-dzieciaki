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

    private void createTimer() {
        timer = new Timer(DELAY, this);
        timer.start();
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
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Kid kid;
        for( int i = 0; i < Configuration.NUMBER_OF_CHILDREN; ++i){
            kid = kids.get(i);
            g.drawImage(kid.getIcon(), kid.position.x * 26, kid.position.y * 20, 24, 24,  null);
        }

        GiftHandler giftHandler = GiftHandler.getInstance();
        
        for( int i = 0; i < giftHandler.getCount(); ++i){
            Gift gift = giftHandler.getGiftByIndex(i);
            g.drawImage(gift.getIcon(), gift.position.x * 26, gift.position.y * 20, 24, 24,  null);
        }
        
        if(AreaScanner.isConflict(kids, santa)){
            System.out.println("kolizja");
        }

        Kid thisKid = AreaScanner.getKidFromNeighborhood(kids, santa);
        if(thisKid != null) {
            thisKid.setAsGrounded();
        }
        
        g.drawImage(santa.getIcon(),santa.position.x * 26, santa.position.y * 20, 24, 24,  null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        
        santa.move();
        repaint();
    }
    
}
