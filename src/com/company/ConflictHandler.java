package com.company;

import com.company.characters.*;

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

    public static Kid getKidFromNeighborhood(ArrayList<Kid> kids, Santa santa) {
        for( int i = 0; i < kids.size(); ++ i ){
            if ( isInTheArea(kids.get(i), santa) && 
                            itIsNotTheSameObject(kids.get(i), santa))
                return kids.get(i);
        }

        return null;
    }

    private static boolean isInTheArea(Kid kid, Santa santa) {
        return ifItIsAtTheTop(kid, santa) || ifItIsAtTheBottom(kid, santa)|| ifItIsOnTheLeft(kid, santa) || ifItIsOnTheRight(kid, santa);
    }

    private static boolean ifItIsAtTheTop(Kid kid, Santa santa) {
        return kid.position.x == santa.position.x && kid.position.y == santa.position.y+1;
    }
    
    private static boolean ifItIsAtTheBottom(Kid kid, Santa santa) {
        return kid.position.x == santa.position.x && kid.position.y == santa.position.y-1;
    }
    
    private static boolean ifItIsOnTheLeft(Kid kid, Santa santa) {
        return kid.position.x == santa.position.x+1 && kid.position.y == santa.position.y;
    }

    private static boolean ifItIsOnTheRight(Kid kid, Santa santa) {
        return kid.position.x == santa.position.x-1 && kid.position.y == santa.position.y;
    }
}
