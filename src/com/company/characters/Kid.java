package com.company.characters;

import com.company.*;

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
                
                if(AreaScanner.isConflict(KidsHandler.getInstance().getKids(), this)){
                    moveLeft();
                    moveRandomWay();
                }
                
                break;
            case 1:
                moveLeft();

                if(AreaScanner.isConflict(KidsHandler.getInstance().getKids(), this)){
                    moveRight();
                    moveRandomWay();
                }
                
                break;
            case 2:
                moveUp();

                if(AreaScanner.isConflict(KidsHandler.getInstance().getKids(), this)){
                    moveDown();
                    moveRandomWay();
                }
                
                
                break;
            default:
                moveDown();

                if(AreaScanner.isConflict(KidsHandler.getInstance().getKids(), this)){
                    moveUp();
                    moveRandomWay();
                }
                
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
        if( ! grounded && gift.active ) {
            image = Configuration.KID_GROUNDED_IMAGE;
            position = gift.position;
            gift.active = false;
            grounded = true;
        }
    }

    public synchronized void moveTo(Point point) {
        if( point.x > position.x ) {
            moveRight();
        }
        else if( point.x < position.x ) {
            moveLeft();
        }
        else if( point.y > position.y ){
            moveUp();
        }
        else{
            moveDown();
        }
    }
    
    public synchronized void play(Thread thread) {
        Reminder reminder = new Reminder(5);
        wakeUp();
        
        while( ! reminder.end && ! grounded ){
            if (isGiftNear()) return;

            Santa santa = Santa.getInstance();
            if(AreaScanner.isObjectNear(position, santa)) {
                moveTo(santa.position);
                wait(thread, 500);
                
            }
            else{
                moveRandomWay();
                wait(thread, 1000);
            }
        }
        
        sleep();
    }
    
    private synchronized void wakeUp() {
        image = Configuration.KID_IMAGE;
    }
    
    private boolean isGiftNear() {
        GiftHandler giftHandler = GiftHandler.getInstance();
        Gift gift;

        for( int i = 0; i < giftHandler.getCount(); ++i){
            gift = giftHandler.getGiftByIndex(i);

            if(AreaScanner.isInTheArea(this, gift) && gift.active) {
                setAsGrounded(gift);
                return true;
            }
        }
        return false;
    }

    private void wait(Thread thread, int second) {
        try {
            thread.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void sleep() {
        image = Configuration.KID_SLEEPING_IMAGE;
    }
    
}
