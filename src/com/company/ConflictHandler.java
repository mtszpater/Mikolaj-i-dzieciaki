package com.company;

import java.util.ArrayList;

/**
 * author @pater
 */
public class ConflictHandler {
    public static boolean isConflict(ArrayList<? extends Char> kids, Char santa) {
        
        for( int i = 0; i < kids.size(); ++ i ){
            if (hasTheSamePosition(kids.get(i), santa) && itIsNotTheSameObject(kids.get(i), santa))
                return true;
        }
        
        return false;
        
    }

    private static boolean itIsNotTheSameObject(Char first, Char second) {
        return first != second;
    }

    private static boolean hasTheSamePosition(Char first, Char second) {
        return first.position.x == second.position.x && first.position.y == second.position.y;
    }
}
