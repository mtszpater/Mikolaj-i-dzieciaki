package com.company;

import javax.swing.*;
import java.util.Random;

/**
 * author @pater
 */
public class Kid extends Char{
    boolean grounded;
    
    public Kid() {
        grounded = false;
        image = "../../images/kid.png";

        movingInBackground();
        
    }

    private void movingInBackground() {
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                while(!grounded) {
                    Thread.sleep(2000);
                    moveRandomWay();
                    System.out.println("Current position : "+ position.x + " , " +  position.y );
                }
                image = "../../images/grounded.png";
                return null;
            }
        };

        worker.execute();
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
}
