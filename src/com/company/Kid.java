package com.company;

import java.util.Random;

/**
 * author @pater
 */
public class Kid extends Char{

    public Kid() {
        image = "../../images/kid.png";
    }

    public void moveInRandomWay(){
        Random random = new Random();

        int wayOption = random.nextInt(4);

        switch( wayOption ) {
            case 1:
                moveLeft();
                break;
            case 2:
                moveDown();
                break;
            case 3:
                moveRight();
                break;
            default:
                moveUp();
                break;
        }
    }
}
