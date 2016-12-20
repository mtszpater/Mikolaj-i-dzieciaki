package com.company;

import com.company.characters.*;

import java.util.ArrayList;

/**
 * author @pater
 */
public class AreaScanner {
    public static boolean isConflict(ArrayList<? extends Char> kids, Char santa) {

        for (Char kid : kids) {
            if (hasTheSamePosition(kid, santa) && itIsNotTheSameObject(kid, santa))
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

    public static Kid getKidFromNeighborhood(ArrayList<Kid> kids, Gift gift) {
        for( int i = 0; i < kids.size(); ++ i ){
            if ( isInTheArea(kids.get(i), gift) )
                return kids.get(i);
        }

        return null;
    }

    public static boolean isInTheArea(Kid kid, Gift gift) {
        return  ifItIsAtTheTop(kid, gift) ||
                ifItIsAtTheBottom(kid, gift)|| 
                ifItIsOnTheLeft(kid, gift) || 
                ifItIsOnTheRight(kid, gift) || 
                ifItIsOnTheLeftTop(kid, gift) || 
                ifItIsOnTheRightTop(kid, gift) || 
                ifItIsOnTheLeftDown(kid, gift) || 
                ifItIsOnTheRightDown(kid, gift)
                && gift.active ;
    }

    private static boolean ifItIsAtTheTop(Kid kid, ObjectOnBoardImpl gift) {
        return kid.position.x == gift.position.x && kid.position.y == gift.position.y+1;
    }
    
    private static boolean ifItIsAtTheBottom(Kid kid, ObjectOnBoardImpl gift) {
        return kid.position.x == gift.position.x && kid.position.y == gift.position.y-1;
    }
    
    private static boolean ifItIsOnTheLeft(Kid kid, ObjectOnBoardImpl gift) {
        return kid.position.x == gift.position.x+1 && kid.position.y == gift.position.y;
    }

    private static boolean ifItIsOnTheRight(Kid kid, ObjectOnBoardImpl gift) {
        return kid.position.x == gift.position.x-1 && kid.position.y == gift.position.y;
    }

    private static boolean ifItIsOnTheLeftTop(Kid kid, ObjectOnBoardImpl gift) {
        return kid.position.x == gift.position.x+1 && kid.position.y+1 == gift.position.y;
    }

    private static boolean ifItIsOnTheRightTop(Kid kid, ObjectOnBoardImpl gift) {
        return kid.position.x == gift.position.x-1 && kid.position.y+1 == gift.position.y;
    }

    private static boolean ifItIsOnTheLeftDown(Kid kid, ObjectOnBoardImpl gift) {
        return kid.position.x == gift.position.x+1 && kid.position.y-1 == gift.position.y;
    }

    private static boolean ifItIsOnTheRightDown(Kid kid, ObjectOnBoardImpl gift) {
        return kid.position.x == gift.position.x-1 && kid.position.y-1 == gift.position.y;
    }

    public static boolean isObjectNear(Point point, ObjectOnBoardImpl object) {
        if(isInRange(point.x, object.position.x) && isInRange(point.y, object.position.y)){
            return true;
        }
        return false;
    }

    private static boolean isInRange(int arg_1, int arg_2) {
        return arg_1 - arg_2 <= 4 && arg_1 - arg_2 >= -4;
    }
}
