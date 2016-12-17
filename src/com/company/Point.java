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
}
