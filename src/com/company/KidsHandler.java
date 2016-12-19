package com.company;

import com.company.characters.Gift;
import com.company.characters.Kid;

import java.awt.*;
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
    
    public void drawKids(Graphics g){
        Kid kid;
        for(int i = 0; i < Configuration.NUMBER_OF_CHILDREN; ++i){
            kid = kids.get(i);

            if( kid.grounded )
                g.drawImage(kid.getIcon(), kid.position.x * Configuration.WIDTH_SCALE, kid.position.y * Configuration.HEIGHT_SCALE, Configuration.ICON_SIZE, Configuration.ICON_SIZE,  Color.MAGENTA ,null);
            else
                g.drawImage(kid.getIcon(), kid.position.x * Configuration.WIDTH_SCALE, kid.position.y * Configuration.HEIGHT_SCALE, Configuration.ICON_SIZE, Configuration.ICON_SIZE ,null);

        }
    }

    public void checkIfKidGetGift() {
        GiftHandler giftHandler = GiftHandler.getInstance();
        Gift gift;

        for( int i = 0; i < giftHandler.getCount(); ++i){
            gift = giftHandler.getGiftByIndex(i);

            Kid thisKid = AreaScanner.getKidFromNeighborhood(kids, gift);
            if (thisKid != null) {
                thisKid.setAsGrounded(gift);
            }
        }
    }

    public ArrayList<Kid> getKids() {
        return kids;
    }
}
