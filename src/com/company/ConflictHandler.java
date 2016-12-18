package com.company;

import java.util.ArrayList;

/**
 * author @pater
 */
public class ConflictHandler {
    public static boolean isConflict(ArrayList<Kid> kids, Santa santa) {
        
        for( int i = 0; i < kids.size(); ++ i ){
            if (hasTheSamePosition(kids.get(i), santa))
                return true;
        }
        
        return false;
        
    }

    private static boolean hasTheSamePosition(Kid kid, Santa santa) {
        return santa.position.x == kid.position.x && santa.position.y == kid.position.y;
    }
}
