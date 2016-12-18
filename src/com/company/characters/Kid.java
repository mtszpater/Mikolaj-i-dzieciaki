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
        grounded = true;
        image = Configuration.KID_GROUNDED_IMAGE;
    }
}
