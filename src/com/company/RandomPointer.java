package com.company;

import java.util.Random;

/**
 * author @pater
 */
public class RandomPointer {
    
    public static Point generateRandomPoint(int size){
        Random random = new Random();
        int x = random.nextInt(size);
        int y = random.nextInt(size);
        
        return new Point(x,y);
    }
}
