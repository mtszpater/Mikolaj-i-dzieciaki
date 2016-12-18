package com.company.characters;

import com.company.Configuration;

import java.util.Random;

/**
 * author @pater
 */
public class Kid extends Char{
    public boolean grounded;
    
    public Kid() {
        grounded = false;
        image = Configuration.KID_IMAGE;

        KidRunner kidRunner = new KidRunner(this);
        kidRunner.move();
        
    }
    

    public void moveRandomWay() {
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
    
    public void moveRight() {
        dx += 1;
        
        move();
        dx = 0;
    }

    public void moveLeft() {
        dx -= 1;

        move();
        dx = 0;
    }
    
    public void moveDown() {
        dy -= 1;
        
        move();
        dy = 0;
    }

    public void moveUp() {
        dy += 1;

        move();
        dy = 0;
        
    }

    public void setAsGrounded() {
        if( ! grounded) {
            grounded = true;
            setToRandomToyImage();
        }
    }
    
    private void setToRandomToyImage(){
        
        Random random = new Random();
        
        switch( random.nextInt(4) ){
            case 0:
                image = Configuration.TOY_1_IMAGE;
                break;
            case 1:
                image = Configuration.TOY_2_IMAGE;
                break;
            case 2:
                image = Configuration.TOY_3_IMAGE;
                break;
            case 3:
                image = Configuration.TOY_4_IMAGE;
                break;
            default:
                image = Configuration.TOY_5_IMAGE;
                break;
        }
        
    }

    public void play() {
        Reminder reminder = new Reminder(2);

        image = Configuration.PLAY_IMAGE;
        
        while( ! reminder.end){
            System.out.println("bawie sie");
            
        }
        
    }
}