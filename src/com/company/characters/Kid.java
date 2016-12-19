package com.company.characters;

import com.company.Configuration;
import com.company.GiftHandler;

import java.util.Random;

/**
 * author @pater
 */
public class Kid extends Char{
    public boolean grounded;
    
    public Kid() {
        grounded = false;
        image = Configuration.KID_IMAGE;
    }
    
    public synchronized void initMoving(){
        KidRunner kidRunner = new KidRunner(this);
        kidRunner.move();
    }

    synchronized void moveRandomWay() {
        Random random = new Random();
        
        switch(random.nextInt(3)){
            case 0:
                moveRight();
                break;
            case 1:
                moveLeft();
                break;
            case 2:
                moveUp();
                break;
            default:
                moveDown();
                break;
        }
    }
    
    public synchronized void moveRight() {
        dx += 1;
        moveAndClearPosition();
    }

    public synchronized void moveLeft() {
        dx -= 1;
        moveAndClearPosition();
    }
    
    public synchronized void moveDown() {
        dy -= 1;
        moveAndClearPosition();
    }

    public synchronized void moveUp() {
        dy += 1;
        moveAndClearPosition();
    }

    private void moveAndClearPosition() {
        move();
        dx = 0;
        dy = 0;
    }

    public void setAsGrounded(Gift gift) {
        GiftHandler giftHandler = GiftHandler.getInstance();
        if( ! grounded ) {
            grounded = true;
            image = gift.image;
            position = gift.position;
            giftHandler.removedGiftFromList(gift);
        }
    }

    public synchronized void play() {
        Reminder reminder = new Reminder(2);

        image = Configuration.PLAY_IMAGE;
        
        while( ! reminder.end){
            System.out.println("bawie sie");
            
        }
        
    }
}
