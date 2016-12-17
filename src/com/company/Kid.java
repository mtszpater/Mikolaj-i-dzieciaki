package com.company;

import java.util.Random;

/**
 * author @pater
 */
public class Kid extends Char{

    public Kid() {
        image = "../../images/kid.png";
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
    }

    public void moveLeft() {
        dx -= 1;
    }
    
    public void moveDown() {
        dy -= 1;
    }

    public void moveUp() {
        dy += 1;
    }
}
