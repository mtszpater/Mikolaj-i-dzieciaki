package com.company;

import com.company.characters.Gift;

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
    
    
}
