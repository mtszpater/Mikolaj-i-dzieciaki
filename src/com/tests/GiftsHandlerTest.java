package com.tests;

import com.company.GiftHandler;
import com.company.Point;
import com.company.characters.Gift;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * author @pater
 */
public class GiftsHandlerTest {
    
    @Test
    public void ifIAddGiftIShouldHaveOne(){
        
        Gift gift = new Gift();
        gift.setPosition( new Point(3,4) );
        GiftHandler giftHandler = GiftHandler.getInstance();
        giftHandler.clear();
        
        giftHandler.addGiftToList(gift);
        
        assertEquals( giftHandler.getCount(), 1);
    }
    
    @Test
    public void ifIAddGiftsIWantToGetThem(){
        GiftHandler giftHandler = GiftHandler.getInstance();
        giftHandler.clear();


        Gift gift = new Gift();
        gift.setPosition( new Point(3,4) );
        
        giftHandler.addGiftToList(gift);
        gift = new Gift();
        gift.setPosition( new Point(3,4) );
        giftHandler.addGiftToList(gift);
        
        
        assertEquals( giftHandler.getGifts().size(), 2);
    }
    
}
