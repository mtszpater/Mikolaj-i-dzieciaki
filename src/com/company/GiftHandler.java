package com.company;

import com.company.characters.Gift;

import java.awt.*;
import java.util.ArrayList;

/**
 * author @pater
 */
public class GiftHandler {
    private ArrayList<Gift> gifts;
    private static GiftHandler ourInstance = new GiftHandler();

    public static GiftHandler getInstance() {
        return ourInstance;
    }

    private GiftHandler(){
        gifts = new ArrayList<>();
    }

    public void addGiftToList(Gift gift) {
        if( getGiftOnPosition( gift.position ) == null  && getCount() < Configuration.SANTA_BAG_LIMIT)
            gifts.add(gift);
    }

    public int getCount() {
        return gifts.size();
    }

    public ArrayList<Gift> getGifts() {
        return gifts;
    }

    public void clear() {
        gifts = new ArrayList<>();
    }
    
    public Gift getGiftByIndex( int index ){
        return gifts.get(index);
    }

    public Gift getGiftOnPosition(Point point) {
        for (Gift gift : gifts) {
            if (gift.position.x == point.x && gift.position.y == point.y)
                return gift;
        }
        return null;
    }

    public void removedGiftFromList(Gift gift) {
        gifts.remove(gift);
    }

    public void drawGifts(Graphics g) {
        GiftHandler giftHandler = GiftHandler.getInstance();
        Gift gift;

        for( int i = 0; i < giftHandler.getCount(); ++i){
            gift = giftHandler.getGiftByIndex(i);
            if(gift.active) {
                g.drawImage(gift.getIcon(), gift.position.x * Configuration.WIDTH_SCALE, gift.position.y * Configuration.HEIGHT_SCALE, Configuration.ICON_SIZE, Configuration.ICON_SIZE, null);
            }
        }
    }
    
}
