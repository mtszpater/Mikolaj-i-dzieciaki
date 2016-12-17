package com.company;

import java.util.Random;

/**
 * author @pater
 */
public class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void generateRandomPosition(int size){
        Random random = new Random();
        x = random.nextInt(size);
        y = random.nextInt(size);
    }

    public void setX(int x) {
        if( x > 30 ) x = (x-1) % 30;
        if( x < 0 ) x = (x%30) + 30;
        
        this.x = x;
    }

    public void setY(int y) {
        if( y > 30 ) y = (y-1) % 30;
        if( y < 0 ) y = (y%30) + 30;
        
        this.y = y;
    }
}
