package com.company;

import com.company.characters.*;

import java.util.ArrayList;

/**
 * author @pater
 */
public class AreaScanner {
    public static boolean isConflict(ArrayList<Kid> kids, Char santa) {

        for (Kid kid : kids) {
            if (hasTheSamePosition(kid, santa) && itIsNotTheSameObject(kid, santa) && ! kid.grounded)
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

    private static boolean ifItIsAtTheTop(Kid kid, ObjectOnBoardImpl object) {
        return kid.position.x == object.position.x && kid.position.y == object.position.y+1;
    }
    
    private static boolean ifItIsAtTheBottom(Kid kid, ObjectOnBoardImpl object) {
        return kid.position.x == object.position.x && kid.position.y == object.position.y-1;
    }
    
    private static boolean ifItIsOnTheLeft(Kid kid, ObjectOnBoardImpl object) {
        return kid.position.x == object.position.x+1 && kid.position.y == object.position.y;
    }

    private static boolean ifItIsOnTheRight(Kid kid, ObjectOnBoardImpl object) {
        return kid.position.x == object.position.x-1 && kid.position.y == object.position.y;
    }

    private static boolean ifItIsOnTheLeftTop(Kid kid, ObjectOnBoardImpl object) {
        return kid.position.x == object.position.x+1 && kid.position.y+1 == object.position.y;
    }

    private static boolean ifItIsOnTheRightTop(Kid kid, ObjectOnBoardImpl object) {
        return kid.position.x == object.position.x-1 && kid.position.y+1 == object.position.y;
    }

    private static boolean ifItIsOnTheLeftDown(Kid kid, ObjectOnBoardImpl object) {
        return kid.position.x == object.position.x+1 && kid.position.y-1 == object.position.y;
    }

    private static boolean ifItIsOnTheRightDown(Kid kid, ObjectOnBoardImpl object) {
        return kid.position.x == object.position.x-1 && kid.position.y-1 == object.position.y;
    }

    public static boolean isObjectNear(Point point, ObjectOnBoardImpl object) {
        return isInRangeOfFour(point.x, object.position.x) && isInRangeOfFour(point.y, object.position.y);
    }

    private static boolean isInRangeOfFour(int arg_1, int arg_2) {
        return arg_1 - arg_2 <= 4 && arg_1 - arg_2 >= -4;
    }
}
