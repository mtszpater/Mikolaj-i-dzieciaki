package com.company;

import com.company.characters.Kid;

import java.util.ArrayList;

/**
 * author @pater
 */
public class KidsHandler {
    private static KidsHandler ourInstance = new KidsHandler();
    private ArrayList<Kid> kids = new ArrayList<>();
    
    public static KidsHandler getInstance() {
        return ourInstance;
    }

    private KidsHandler() {
    }

    public void createKids(Board board){
        Kid kid;

        int i = 0;
        
        while (i < Configuration.NUMBER_OF_CHILDREN) {
            kid = new Kid();
            Point point = board.setToRandomEmptyPlace(kid);
            kid.setPosition(point);
            kid.initMoving();
            kids.add(kid);
            ++i;
        }
    }

    public ArrayList<Kid> getKids() {
        return kids;
    }

    public Kid getKidByIndex(int index) {
        return kids.get(index);
    }

    public int getCountOfGroundedKids() {
        int count = 0;

        for (Kid kid : kids) {
            if (kid.grounded) {
                ++count;
            }
        }
        
        return count;
    }
}
